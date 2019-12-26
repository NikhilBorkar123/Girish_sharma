package com.example.abc.girishsharma;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
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
import com.example.abc.girishsharma.Modal.AppointmentData;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

<<<<<<< HEAD
public class AppointmentFragment extends Fragment {
    String pur, nam, ema, prf, pho, ad1, ad2, cit, sta, pin, refn, refp, refph;
    TextInputLayout purpose, name, email, phone, adrs1, adrs2, city, state, pinc, refname, refpost, refphone;
=======
public class AppointmentFragment extends Fragment{
//    EditText editPurpose,editName,editEmail,editPhone,editAddress1,editAddress2,editCity,editState,editPincode,editRefernceName,editReferncePost,editReferncePhone;
//
//    private Button editbtn;
//
//    private LinearLayout linearLayout;
//
//    public static final String Base_URL = "http://iamapp.incubatorsdwnmt.com/api/";
//
//    private AwesomeValidation awesomeValidation;
//
//    private String proff;
//
//    private ApiInterface apiInterface;
//
//    View view;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view= inflater.inflate(R.layout.fragment_appointment,container,false);
//
//        editbtn = view.findViewById(R.id.editbtn);
//
//        linearLayout = view.findViewById(R.id.linear);
//
//        awesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);
//        findViews();
//        validateForm();
//        try {
//            initSpinner();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Base_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiInterface = retrofit.create(ApiInterface.class);
//        editbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(awesomeValidation.validate()) {
//                    try {
//                        submitForm();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                Log.e("Onclick event","Form submitted successfully|!");
//            }
//        });
//        return view;
//    }
//    private void findViews(){
//        editPurpose =view.findViewById(R.id.editPurpose);
//        editName =  view.findViewById(R.id.editName);
//        editEmail =  view.findViewById(R.id.editEmail);
//        editPhone =  view.findViewById(R.id.editPhone);
//        editAddress1=  view.findViewById(R.id.editAddress1);
//        editAddress2=  view.findViewById(R.id.editAddress2);
//        editCity =  view.findViewById(R.id.editCity);
//        editState =  view.findViewById(R.id.editState);
//        editPincode =  view.findViewById(R.id.editPincode);
//        editRefernceName =  view.findViewById(R.id.editRefernceName);
//        editReferncePost =  view.findViewById(R.id.editReferncePost);
//        editReferncePhone =  view.findViewById(R.id.editReferncePhone);
//
//    }
//    private void validateForm(){
//
//        awesomeValidation.addValidation(getActivity(),R.id.editPurpose,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editEmail, Patterns.EMAIL_ADDRESS, R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editPhone, RegexTemplate.TELEPHONE, R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editCity, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editState, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editRefernceName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(getActivity(), R.id.editReferncePost, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//    }
//
//    private void initSpinner() throws Exception{
//        Spinner spinner = view.findViewById(R.id.spinner1);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.Profession, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
//
//    }
//
//
//    private void submitForm() throws Exception {
//
//        (apiInterface.postAppointments(editPurpose.getText().toString().trim(),
//                editName.getText().toString().trim(),
//                editEmail.getText().toString().trim(),
//                editPhone.getText().toString().trim(),
//                editAddress1.getText().toString().trim(),
//                editAddress2.getText().toString().trim(),
//                editCity.getText().toString().trim(),
//                editState.getText().toString().trim(),
//                editPincode.getText().toString().trim(),
//                editRefernceName.getText().toString().trim(),
//                editReferncePost.getText().toString().trim(),
//                editReferncePhone.getText().toString().trim(),
//                proff
//        )).enqueue(new Callback<Appointment>() {
//            @Override
//            public void onResponse(Call<Appointment> call, Response<Appointment> response) {
//                try {
//                    Call<Appointment> userdetails = call;
//                    Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
//                    Log.e("onResponse","Submitted successfully");
//                }catch (Exception e){
//                    Log.e("submitFrom",e.toString());
//                }
//            }
//            @Override
//            public void onFailure(retrofit2.Call<Appointment> call, Throwable t) {
//                Toast.makeText(getContext(), toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        proff = parent.getItemAtPosition(position).toString();
//        Log.e("onItemSelected",proff);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//
    String pur,nam,ema,prf,pho,ad1,ad2,cit,sta,pin,refn,refp,refph;
    TextInputLayout purpose,name,email,phone,adrs1,adrs2,city,state,pinc,refname,refpost,refphone;
>>>>>>> 13b40d0e80a505aafda781b8b5c38f78b8eb8ad5
    Spinner profession;
//    private AwesomeValidation awesomeValidation;

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
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        view = inflater.inflate(R.layout.fragment_appointment, container, false);
=======
        view= inflater.inflate(R.layout.fragment_appointment,container,false);
>>>>>>> 13b40d0e80a505aafda781b8b5c38f78b8eb8ad5
//        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
//        validateForm();
        findViews();
//        getApp();
        view.findViewById(R.id.subbtn1).setOnClickListener(new View.OnClickListener() {
            @Override
<<<<<<< HEAD
            public void onClick(View v) {
//                getApp();
//                validateForm();
//                if(awesomeValidation.validate()) {
                try {
//                        getApp();
                    sendAppDetails();
                } catch (Exception e) {
                    e.printStackTrace();
                }
=======
            public void onClick(View v){
//                getApp();
//                validateForm();
//                if(awesomeValidation.validate()) {
                    try {
//                        getApp();
                        sendAppDetails();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
>>>>>>> 13b40d0e80a505aafda781b8b5c38f78b8eb8ad5
//                }
            }
        });

        profession = view.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spinnerValue);
        profession.setAdapter(adapter);

        profession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //set selected spinner value here.......
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        return view;
    }
    private void findViews() {
        purpose = view.findViewById(R.id.purpose);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        adrs1 = view.findViewById(R.id.Address1);
        adrs2 = view.findViewById(R.id.Address2);
        profession = view.findViewById(R.id.spProf);
        city = view.findViewById(R.id.city);
        state = view.findViewById(R.id.state);
        pinc = view.findViewById(R.id.pincode);
        refname = view.findViewById(R.id.refname);
        refpost = view.findViewById(R.id.refpost);
        refphone = view.findViewById(R.id.refphone);

    private void findViews() {
        purpose = view.findViewById(R.id.purpose);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        adrs1 = view.findViewById(R.id.Address1);
        adrs2 = view.findViewById(R.id.Address2);
        profession = view.findViewById(R.id.spProf);
        city = view.findViewById(R.id.city);
        state = view.findViewById(R.id.state);
        pinc = view.findViewById(R.id.pincode);
        refname = view.findViewById(R.id.refname);
        refpost = view.findViewById(R.id.refpost);
        refphone = view.findViewById(R.id.refphone);


    }

//    private void validateForm(){
//        awesomeValidation.addValidation((Activity) getContext(),R.id.purpose,"[a-zA-Z\\s]+",R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.Address1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.Address2, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.pincode, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.email, Patterns.EMAIL_ADDRESS, R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.phone, RegexTemplate.TELEPHONE, R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.city, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.state, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.refname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.refpost, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation((Activity) getContext(), R.id.refphone, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//
//    }
//    private void getApp() {
//        pur = purpose.getEditText().getText().toString();
//        nam = name.getEditText().getText().toString();
//        prf = profession.getSelectedItem().toString();
//        ema = email.getEditText().getText().toString();
//        pho = phone.getEditText().getText().toString();
//        ad1 = adrs1.getEditText().getText().toString();
//        ad2 = adrs2.getEditText().getText().toString();
//        cit = city.getEditText().getText().toString();
//        sta = state.getEditText().getText().toString();
//        pin = pinc.getEditText().getText().toString();
//        refn = refname.getEditText().getText().toString();
//        refp = refphone.getEditText().getText().toString();
//        refph = refpost.getEditText().getText().toString();

<<<<<<< HEAD
    //    }
=======
//    }
>>>>>>> 13b40d0e80a505aafda781b8b5c38f78b8eb8ad5
    private void sendAppDetails() {

        pur = purpose.getEditText().getText().toString();
        nam = name.getEditText().getText().toString();
        prf = profession.getSelectedItem().toString();
        ema = email.getEditText().getText().toString();
        pho = phone.getEditText().getText().toString();
        ad1 = adrs1.getEditText().getText().toString();
        ad2 = adrs2.getEditText().getText().toString();
        cit = city.getEditText().getText().toString();
        sta = state.getEditText().getText().toString();
        pin = pinc.getEditText().getText().toString();
        refn = refname.getEditText().getText().toString();
        refp = refphone.getEditText().getText().toString();
        refph = refpost.getEditText().getText().toString();

<<<<<<< HEAD

        Log.e("Params check", pur + nam + prf + ema + pho + ad1 + ad2 + cit + sta + pin + refn + refp + refph);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<AppointmentData> call = apiInterface.sendAppDetails("10", "20", nam, prf, ema, pho, ad1, ad2, cit, sta, pin, pur, refn, refp, refph, "100");
        call.enqueue(new Callback<AppointmentData>() {
            @Override
            public void onResponse(Call<AppointmentData> call, retrofit2.Response<AppointmentData> response) {
                AppointmentData appointment = response.body();
                Log.e("Err check", appointment.getSuccess().toString());
                if (appointment != null) {
                    if (appointment.getSuccess()) {
//                        Log.v("yes", volunteer.getData().toString());
                        Toast.makeText(getContext(), "Sumbit data successfully...", Toast.LENGTH_SHORT).show();
                    } else {
//                        Log.v("no", volunteer.getData().toString());
                        Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                        assert volunteer != null;
                    Log.v("Response error", appointment.toString());
                }
            }

            @Override
            public void onFailure(Call<AppointmentData> call, Throwable t) {
                Log.e("Error Response", t.toString());
            }
        });
    }

=======


        Log.e("Params check",pur+nam+prf+ema+pho+ad1+ad2+cit+sta+pin+refn+refp+refph);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<AppointmentData> call = apiInterface.sendAppDetails("10","20",nam,prf,ema,pho,ad1,ad2,cit,sta,pin,pur,refn,refp,refph,"100");
        call.enqueue(new Callback<AppointmentData>() {
            @Override
            public void onResponse(Call<AppointmentData> call, retrofit2.Response<AppointmentData> response) {
                AppointmentData appointment = response.body();
                Log.e("Err check",appointment.getSuccess().toString());
                if (appointment != null) {
                    if (appointment.getSuccess()) {
//                        Log.v("yes", volunteer.getData().toString());
                        Toast.makeText(getContext(), "Sumbit data successfully...", Toast.LENGTH_SHORT).show();
                    } else {
//                        Log.v("no", volunteer.getData().toString());
                        Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                    }
                } else{
//                        assert volunteer != null;
                    Log.v("Response error", appointment.toString());
                }
            }
            @Override
            public void onFailure(Call<AppointmentData> call, Throwable t) {
                Log.e("Error Response",t.toString());
            }
        });
    }

>>>>>>> 13b40d0e80a505aafda781b8b5c38f78b8eb8ad5
}
