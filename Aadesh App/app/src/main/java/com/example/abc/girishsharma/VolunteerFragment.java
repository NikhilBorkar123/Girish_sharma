package com.example.abc.girishsharma;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.ApiModel;
import com.example.abc.girishsharma.Modal.ApiModelData;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;

public class VolunteerFragment extends Fragment {
    View view;
    RequestBody s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,apid;
    MultipartBody.Part photo;
    private String image;
    TextInputLayout Fname, Lname, Email, Phone, Adr1, Adr2, City, State, Pincode;
    Button submit;
    Spinner profession;
    private UserSes userSes;
    List <ApiModel> data;
    File img;


    private ImageView imgView;
    String[] spinnerValue = {"Profession",
            "Private Company",
            "Government/Public Sector",
            "Social/Political Organisation",
            "Defense/Civil Services",
            "Education Sector",
            "Accounting,banking & finance",
            "Medical & healthcare",
            "Business/Self Employed",
            "Agriculture/Poultry",
            "Student",
            "Non Working"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_volunteer, container, false);
        findViews();

        userSes = new UserSes(getContext());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                sendFormDetails();
            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(imageIntent, 0);
            }
        });

        //set spinner value
        profession = view.findViewById(R.id.spProf);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spinnerValue);
        profession.setAdapter(adapter);

        profession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        });


        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                image = getImageFromUri(selectedImage);


            } else {
                Toast.makeText(getContext(), "please picked a image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Something went wrong in image", Toast.LENGTH_LONG).show();
        }
    }

    public String getImageFromUri(Uri uri) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getContext(), uri, filePathColumn, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String mediaPath = cursor.getString(columnIndex);
        imgView.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
        cursor.close();
        return mediaPath;
    }


    private void findViews() {
        imgView = view.findViewById(R.id.image);
        Fname = view.findViewById(R.id.fname);
        Lname = view.findViewById(R.id.lname);
        profession = view.findViewById(R.id.spProf);
        Email = view.findViewById(R.id.email);
        Phone = view.findViewById(R.id.phone);
        Adr1 = view.findViewById(R.id.Address1);
        Adr2 = view.findViewById(R.id.Address2);
        City = view.findViewById(R.id.city);
        State = view.findViewById(R.id.state);
        Pincode = view.findViewById(R.id.pincode);
        submit = view.findViewById(R.id.subbtn);
    }

    private void getData() {
        s1 = RequestBody.create(MediaType.parse("text/plain"), Fname.getEditText().getText().toString());
        s2 = RequestBody.create(MediaType.parse("text/plain"), Lname.getEditText().getText().toString());
        s3 = RequestBody.create(MediaType.parse("text/plain"), profession.getSelectedItem().toString());
        s4 = RequestBody.create(MediaType.parse("text/plain"), Email.getEditText().getText().toString());
        s5 = RequestBody.create(MediaType.parse("text/plain"), Phone.getEditText().getText().toString());
        s6 = RequestBody.create(MediaType.parse("text/plain"), Adr1.getEditText().getText().toString());
        s7 = RequestBody.create(MediaType.parse("text/plain"), Adr2.getEditText().getText().toString());
        s8 = RequestBody.create(MediaType.parse("text/plain"), City.getEditText().getText().toString());
        s9 = RequestBody.create(MediaType.parse("text/plain"), State.getEditText().getText().toString());
        s10 = RequestBody.create(MediaType.parse("text/plain"), Pincode.getEditText().getText().toString());
        apid = RequestBody.create(MediaType.parse("text/plain"), "50");

        img = new File(image);
//        photo = MultipartBody.Part.createFormData("img", img.getName(), RequestBody.create(MediaType.parse("image/*"), img));

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), img);
        photo = MultipartBody.Part.createFormData("img", img.getName(), requestBody);

    }


    private void sendFormDetails() {

        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Log.e("apid", String.valueOf(apid)
                +String.valueOf(s1)
                +String.valueOf(s2)
                +String.valueOf(s3)
                +String.valueOf(s4)
                +String.valueOf(s5)
                +String.valueOf(s6)
                +String.valueOf(s7)
                +String.valueOf(s8)
                +String.valueOf(s9)
                +String.valueOf(s10)
                +String.valueOf(photo)
        );

        Call<ApiModelData> call = apiInterface.sendDetails(null, apid, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, null, photo);
        call.enqueue(new Callback<ApiModelData>() {
            @Override
            public void onResponse(Call<ApiModelData> call, retrofit2.Response<ApiModelData> response) {
                response.body().setData(data);
                Log.e("send details res","" + response.body().getData());

                ApiModelData volunteer = response.body();
                if (volunteer != null) {
                    if (volunteer.getSuccess()) {
                        Log.e("yes", volunteer.toString());
                        Toast.makeText(getContext(), "Sumbit data successfully...", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("no", volunteer.toString());
                        Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "server response...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert volunteer != null;
                    Log.e("Response error", volunteer.toString());
                }
            }

            @Override
            public void onFailure(Call<ApiModelData> call, Throwable t) {
                Log.e("send details err","" + t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
