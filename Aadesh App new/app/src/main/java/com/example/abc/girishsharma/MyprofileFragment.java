package com.example.abc.girishsharma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.UpdateProfile;
import com.example.abc.girishsharma.Modal.UpdateProfileData;
import com.google.gson.JsonObject;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class MyprofileFragment extends Fragment {
    View view;
    TextInputLayout name, email, mobno;
//    String nam, ema, mob, cmsID, appID;
    RequestBody pic,nam, ema, mob, cmsID, appID;
    Button update;
    Uri selectedImage;
    String mediaPath;
    private CircleImageView image;
    VolunteerDatum volunteerDatum = new VolunteerDatum();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myprofile, container, false);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        mobno = view.findViewById(R.id.MobileNo);
        update = view.findViewById(R.id.upd);
        image = view.findViewById(R.id.image);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                sendData();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(imageIntent, 0);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
                selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                mediaPath = cursor.getString(columnIndex);
                image.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
                cursor.close();
                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                image.setImageBitmap(bitmapImage);
            } else {
                Toast.makeText(getContext(), "please picked a image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Something went wrong in image", Toast.LENGTH_LONG).show();
        }
    }

    private void getData() {
        nam = RequestBody.create(MediaType.parse("text/plain"), name.getEditText().getText().toString());
        volunteerDatum.setFname(name.getEditText().getText().toString());
        ema = RequestBody.create(MediaType.parse("text/plain"), email.getEditText().getText().toString());
        volunteerDatum.setLname(email.getEditText().getText().toString());
        mob = RequestBody.create(MediaType.parse("text/plain"), mobno.getEditText().getText().toString());
        volunteerDatum.setProfession(mobno.getEditText().getText().toString());
        cmsID = RequestBody.create(MediaType.parse("text/plain"), "2");
        volunteerDatum.setVolunteerID("2");
        appID = RequestBody.create(MediaType.parse("text/plain"), "795");
        volunteerDatum.setAppUserID("795");

//        nam = name.getEditText().getText().toString();
//        ema = email.getEditText().getText().toString();
//        mob = mobno.getEditText().getText().toString();
//        cmsID = getString(R.string.CMSUserAuthenticationID);
//        appID = "795";
    }

    private void sendData() {
        File file = new File(mediaPath);
        Log.e("file path is :", mediaPath);
        Log.e("isFile", "" + file.isFile());
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        pic = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("profileImage", file.getName(), pic);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<UpdateProfileData> call = apiInterface.sendUpdate(appID, nam, ema, mob, cmsID, body);
        Log.e("call is", "" + call);
        Log.e("Params: ", " " + appID+" " + nam+" " + ema+" " + mob+" " + cmsID+" " + body);
        call.enqueue(new Callback<UpdateProfileData>() {
            @Override
            public void onResponse(Call<UpdateProfileData> call, Response<UpdateProfileData> response) {

                UpdateProfileData update = response.body();
//                Log.e("update res", update + "");
//                String data = update.getData().getAppUserID();
                Boolean msg = update.getSuccess();
//                Log.e("the success message is", data + "");
                Log.e("the success message is", msg + "");
//                if (update != null) {
                if (msg) {
                    Toast.makeText(getContext(), "Submit data successfully...", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(getContext())
                            .setTitle("Your profile updated successfully....")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                                }
                            })
                            .show();
                } else {
//                    Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(),msg+"",Toast.LENGTH_LONG).show();
                }
//                } else {
//                    assert update != null;
//                    Log.v("Response error", update.toString());
//                }

            }

            @Override
            public void onFailure(Call<UpdateProfileData> call, Throwable t) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

}
