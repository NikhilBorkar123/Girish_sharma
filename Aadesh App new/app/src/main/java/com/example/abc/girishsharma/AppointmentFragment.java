package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppointmentFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private EditText editPurpose,editName,editEmail,editPhone,editAddress1,editAddress2,editCity,editState,editPincode,editRefernceName,editReferncePost,editReferncePhone;

    private Button editbtn;

    private LinearLayout linearLayout;

    public static final String Base_URL = "http://iamapp.incubatorsdwnmt.com/api/";

    private AwesomeValidation awesomeValidation;

    private String proff;

    private ApiInterface apiInterface;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_appointment,container,false);

        editbtn = view.findViewById(R.id.editbtn);

        linearLayout = view.findViewById(R.id.linear);

        awesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);
        findViews();
        validateForm();
        try {
            initSpinner();
        }catch (Exception e){
            e.printStackTrace();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()) {
                    try {
                        submitForm();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Log.e("Onclick event","Form submitted successfully|!");
            }
        });
        return view;
    }
    private void findViews(){
        editPurpose =view.findViewById(R.id.editPurpose);
        editName =  view.findViewById(R.id.editName);
        editEmail =  view.findViewById(R.id.editEmail);
        editPhone =  view.findViewById(R.id.editPhone);
        editAddress1=  view.findViewById(R.id.editAddress1);
        editAddress2=  view.findViewById(R.id.editAddress2);
        editCity =  view.findViewById(R.id.editCity);
        editState =  view.findViewById(R.id.editState);
        editPincode =  view.findViewById(R.id.editPincode);
        editRefernceName =  view.findViewById(R.id.editRefernceName);
        editReferncePost =  view.findViewById(R.id.editReferncePost);
        editReferncePhone =  view.findViewById(R.id.editReferncePhone);

    }
    private void validateForm(){

        awesomeValidation.addValidation(getActivity(),R.id.editPurpose,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editEmail, Patterns.EMAIL_ADDRESS, R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editPhone, RegexTemplate.TELEPHONE, R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editCity, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editState, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editRefernceName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.editReferncePost, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
    }

    private void initSpinner() throws Exception{
        Spinner spinner = view.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.Profession, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    private void submitForm() throws Exception {

        (apiInterface.postAppointments(editPurpose.getText().toString().trim(),
                editName.getText().toString().trim(),
                editEmail.getText().toString().trim(),
                editPhone.getText().toString().trim(),
                editAddress1.getText().toString().trim(),
                editAddress2.getText().toString().trim(),
                editCity.getText().toString().trim(),
                editState.getText().toString().trim(),
                editPincode.getText().toString().trim(),
                editRefernceName.getText().toString().trim(),
                editReferncePost.getText().toString().trim(),
                editReferncePhone.getText().toString().trim(),
                proff
        )).enqueue(new Callback<Appointment>() {
            @Override
            public void onResponse(Call<Appointment> call, Response<Appointment> response) {
                try {
                    Call<Appointment> userdetails = call;
                    Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                    Log.e("onResponse","Submitted successfully");
                }catch (Exception e){
                    Log.e("submitFrom",e.toString());
                }
            }
            @Override
            public void onFailure(retrofit2.Call<Appointment> call, Throwable t) {
                Toast.makeText(getContext(), toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        proff = parent.getItemAtPosition(position).toString();
        Log.e("onItemSelected",proff);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
