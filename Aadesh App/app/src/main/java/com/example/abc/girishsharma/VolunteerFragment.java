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
import android.support.v4.content.CursorLoader;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;

public class VolunteerFragment extends Fragment {
    View view;
    private String image,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    TextInputLayout Fname, Lname, Email, Phone, Adr1, Adr2, City, State, Pincode;
    Button submit;
    Spinner profession;
    private UserSes userSes;


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


        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                imgView.setImageBitmap(bitmapImage);


                Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(selectedImage));
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, false);
                image = ConvertBitmapToString(resizedBitmap);


            } else {
                Toast.makeText(getContext(), "please picked a image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    public static String ConvertBitmapToString(Bitmap bitmap){
        String encodedImage = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            encodedImage= URLEncoder.encode(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedImage;
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
        s1 = Fname.getEditText().getText().toString();
        s2 = Lname.getEditText().getText().toString();
        s3 = profession.getSelectedItem().toString();
        s4 = Email.getEditText().getText().toString();
        s5 = Phone.getEditText().getText().toString();
        s6 = Adr1.getEditText().getText().toString();
        s7 = Adr2.getEditText().getText().toString();
        s8 = City.getEditText().getText().toString();
        s9 = State.getEditText().getText().toString();
        s10 = Pincode.getEditText().getText().toString();
    }

    private void sendFormDetails() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiModelData> call = apiInterface.sendDetails(null,null, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, userSes.getCMSUserAuthenticationID(),image);
        call.enqueue(new Callback<ApiModelData>() {
            @Override
            public void onResponse(Call<ApiModelData> call, retrofit2.Response<ApiModelData> response) {

                ApiModelData volunteer = response.body();
                if (volunteer != null) {
                    if (volunteer.getSuccess()) {
                        Toast.makeText(getContext(), "Sumbit data successfully...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "server response...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert volunteer != null;
                    Log.v("Response error", volunteer.toString());
                }

            }

            @Override
            public void onFailure(Call<ApiModelData> call, Throwable t) {
            }
        });
    }
}
