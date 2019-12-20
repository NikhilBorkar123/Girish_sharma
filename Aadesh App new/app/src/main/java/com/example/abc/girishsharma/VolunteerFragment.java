package com.example.abc.girishsharma;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.ApiModelData;
import com.example.abc.girishsharma.Modal.Response;
import com.example.abc.girishsharma.Modal.Volunteer;
import com.google.gson.JsonObject;

import java.io.ByteArrayOutputStream;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;

public class VolunteerFragment extends Fragment {
    View view;
    String mediaPath,proff;
    Uri selectedImage;
    VolunteerDatum volunteerDatum = new VolunteerDatum();
    //private String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,pic;
    RequestBody s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,pic,volID,appID,cmiId;
    TextInputLayout Fname, Lname, Email, Phone, Adr1, Adr2, City, State, Pincode;
    Button submit;
    Spinner profession;


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
        view.findViewById(R.id.subbtn).setOnClickListener(new View.OnClickListener() {
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
                //set selected spinner value here.......
                proff=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

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
                imgView.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
                cursor.close();
                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                imgView.setImageBitmap(bitmapImage);
            } else {
                Toast.makeText(getContext(), "please picked a image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Something went wrong in image", Toast.LENGTH_LONG).show();
        }
    }

    private void findViews() {
        imgView = view.findViewById(R.id.image);
        Fname = view.findViewById(R.id.fname);
        Lname = view.findViewById(R.id.lname);
//        profession = view.findViewById(R.id.spProf);
        Email = view.findViewById(R.id.email);
        Phone = view.findViewById(R.id.phone);
        Adr1 = view.findViewById(R.id.Address1);
        Adr2 = view.findViewById(R.id.Address2);
        City = view.findViewById(R.id.city);
        State = view.findViewById(R.id.state);
        Pincode = view.findViewById(R.id.pincode);

    }
    private void getData() {

        s1 = RequestBody.create(MediaType.parse("text/plain"), Fname.getEditText().getText().toString());
        volunteerDatum.setFname(Fname.getEditText().getText().toString());

        s2 = RequestBody.create(MediaType.parse("text/plain"), Lname.getEditText().getText().toString());
        volunteerDatum.setLname(Lname.getEditText().getText().toString());

        s3 = RequestBody.create(MediaType.parse("text/plain"), profession.getSelectedItem().toString());
        volunteerDatum.setProfession(proff);

        s4 = RequestBody.create(MediaType.parse("text/plain"), Email.getEditText().getText().toString());
        volunteerDatum.setEmail(Email.getEditText().getText().toString());

        s5 = RequestBody.create(MediaType.parse("text/plain"), Phone.getEditText().getText().toString());
        volunteerDatum.setPhone(Phone.getEditText().getText().toString());

        s6 = RequestBody.create(MediaType.parse("text/plain"), Adr1.getEditText().getText().toString());
        volunteerDatum.setAddress1(Adr1.getEditText().getText().toString());

        s7 = RequestBody.create(MediaType.parse("text/plain"), Adr2.getEditText().getText().toString());
        volunteerDatum.setAddress2(Adr2.getEditText().getText().toString());

        s8 = RequestBody.create(MediaType.parse("text/plain"), City.getEditText().getText().toString());
        volunteerDatum.setCity(City.getEditText().getText().toString());

        s9 = RequestBody.create(MediaType.parse("text/plain"), State.getEditText().getText().toString());
        volunteerDatum.setState(State.getEditText().getText().toString());

        s10 = RequestBody.create(MediaType.parse("text/plain"), Pincode.getEditText().getText().toString());
        volunteerDatum.setPin(Pincode.getEditText().getText().toString());
//        pic = imageString;
        volID = RequestBody.create(MediaType.parse("text/plain"), "1");
        volunteerDatum.setVolunteerID("1");
        appID = RequestBody.create(MediaType.parse("text/plain"), "2");
        volunteerDatum.setAppUserID("2");
        cmiId = RequestBody.create(MediaType.parse("text/plain"),"10");
        volunteerDatum.setCMSUserAuthenticationID("10");
    }
//    private void getData() {
//        s1 = Fname.getEditText().getText().toString();
//        s2 = Lname.getEditText().getText().toString();
//        s3 = profession.getSelectedItem().toString();
//        s4 = Email.getEditText().getText().toString();
//        s5 = Phone.getEditText().getText().toString();
//        s6 = Adr1.getEditText().getText().toString();
//        s7 = Adr2.getEditText().getText().toString();
//        s8 = City.getEditText().getText().toString();
//        s9 = State.getEditText().getText().toString();
//        s10 = Pincode.getEditText().getText().toString();
////        pic = imageString;
//    }

    private void sendFormDetails() {
        File file= new File(mediaPath);
        Log.e("file path is :",mediaPath);

        Log.e("isFile", "" + file.isFile());


        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        pic = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("volunteerImage", file.getName(), pic);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiInterface.sendDetails(volID,appID,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,appID,body);
        Log.e("call is", "" + call);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {

                JsonObject volunteer = response.body();
                Log.e("becomeAVolunteer res", volunteer + "");
//                if (volunteer != null) {
//                    if (volunteer.getSuccess()) {
////                        Log.v("yes", volunteer.getData().toString());
//                        Toast.makeText(getContext(), "Submit data successfully...", Toast.LENGTH_SHORT).show();
//                    } else {
////                        Log.v("no", volunteer.getData().toString());
//                        Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    assert volunteer != null;
//                    Log.v("Response error", volunteer.toString());
//                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}
