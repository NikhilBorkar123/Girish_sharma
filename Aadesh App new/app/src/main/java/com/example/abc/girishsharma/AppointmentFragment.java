package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.abc.girishsharma.Modal.AppointmentData;

import retrofit2.Call;
import retrofit2.Callback;

public class AppointmentFragment extends Fragment {
    String pur, nam, ema, prf, pho, ad1, ad2, cit, sta, pin, refn, refp, refph;
    TextInputLayout purpose, name, email, phone, adrs1, adrs2, city, state, pinc, refname, refpost, refphone;
    Spinner profession;
    Button submit;
    AwesomeValidation awesomeValidation;
    String profVal;
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
        view = inflater.inflate(R.layout.fragment_appointment, container, false);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        findViews();
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profession.getSelectedItem().toString().trim().equals("Profession")) {
                    Toast.makeText(getContext(), "Please select Profession....", Toast.LENGTH_SHORT).show();
                    profVal = "false";
                } else {
                    profVal = "true";
                }
                    awesomeValidation.addValidation(getActivity(), R.id.purpose, "[a-zA-Z\\s]+", R.string.purposeError);
                awesomeValidation.addValidation(getActivity(), R.id.name, "[a-zA-Z\\s]+", R.string.nameError);
                awesomeValidation.addValidation(getActivity(), R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.emailError);
                awesomeValidation.addValidation(getActivity(), R.id.phone, "^[2-9]{2}[0-9]{8}$", R.string.phoneError);
                awesomeValidation.addValidation(getActivity(), R.id.Address1, "[a-zA-Z\\s]+", R.string.addressError);
                awesomeValidation.addValidation(getActivity(), R.id.Address2, "[a-zA-Z\\s]+", R.string.addressError);
                awesomeValidation.addValidation(getActivity(), R.id.city, "[a-zA-Z\\s]+", R.string.cityError);
                awesomeValidation.addValidation(getActivity(), R.id.state, "[a-zA-Z\\s]+", R.string.stateError);
                awesomeValidation.addValidation(getActivity(), R.id.pincode, "^[0-9]{6}$", R.string.pincodeError);
                awesomeValidation.addValidation(getActivity(), R.id.refname, "[a-zA-Z\\s]+", R.string.nameError);
                awesomeValidation.addValidation(getActivity(), R.id.refphone, "^[2-9]{2}[0-9]{8}$", R.string.phoneError);
                awesomeValidation.addValidation(getActivity(), R.id.refpost, "[a-zA-Z\\s]+", R.string.postError);
                if (awesomeValidation.validate() && profVal.equals("true")) {
                    try {
                        sendAppDetails();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    //    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (profession.getSelectedItem().toString().trim().equals("Profession")) {
//                    Toast.makeText(getContext(), "Please select Profession....", Toast.LENGTH_SHORT).show();
//                    profVal = "false";
//                } else {
//                    profVal = "true";
//                }
//                    awesomeValidation.addValidation(getActivity(), R.id.purpose, "[a-zA-Z\\s]+", R.string.purposeError);
//                awesomeValidation.addValidation(getActivity(), R.id.name, "[a-zA-Z\\s]+", R.string.nameError);
//                awesomeValidation.addValidation(getActivity(), R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.emailError);
//                awesomeValidation.addValidation(getActivity(), R.id.phone, "^[2-9]{2}[0-9]{8}$", R.string.phoneError);
//                awesomeValidation.addValidation(getActivity(), R.id.Address1, "[a-zA-Z\\s]+", R.string.addressError);
//                awesomeValidation.addValidation(getActivity(), R.id.Address2, "[a-zA-Z\\s]+", R.string.addressError);
//                awesomeValidation.addValidation(getActivity(), R.id.city, "[a-zA-Z\\s]+", R.string.cityError);
//                awesomeValidation.addValidation(getActivity(), R.id.state, "[a-zA-Z\\s]+", R.string.stateError);
//                awesomeValidation.addValidation(getActivity(), R.id.pincode, "^[0-9]{6}$", R.string.pincodeError);
//                awesomeValidation.addValidation(getActivity(), R.id.refname, "[a-zA-Z\\s]+", R.string.nameError);
//                awesomeValidation.addValidation(getActivity(), R.id.refphone, "^[2-9]{2}[0-9]{8}$", R.string.phoneError);
//                awesomeValidation.addValidation(getActivity(), R.id.refpost, "[a-zA-Z\\s]+", R.string.postError);
//                if (awesomeValidation.validate() && profVal.equals("true")) {
//                    try {
//                        sendAppDetails();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        super.onActivityCreated(savedInstanceState);
//    }
    private void findViews() {
        submit = view.findViewById(R.id.subbtn1);
        purpose = (TextInputLayout) view.findViewById(R.id.purpose);
        name = (TextInputLayout)view.findViewById(R.id.name);
        email = (TextInputLayout)view.findViewById(R.id.email);
        phone = (TextInputLayout)view.findViewById(R.id.phone);
        adrs1 = (TextInputLayout)view.findViewById(R.id.Address1);
        adrs2 = (TextInputLayout)view.findViewById(R.id.Address2);
        profession = view.findViewById(R.id.spProf);
        city = (TextInputLayout)view.findViewById(R.id.city);
        state = (TextInputLayout)view.findViewById(R.id.state);
        pinc = (TextInputLayout)view.findViewById(R.id.pincode);
        refname = (TextInputLayout)view.findViewById(R.id.refname);
        refpost = (TextInputLayout)view.findViewById(R.id.refpost);
        refphone = (TextInputLayout)view.findViewById(R.id.refphone);
    }
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
                        Toast.makeText(getContext(), "Sumbit data successfully...", Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                    } else {
                        Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.v("Response error", appointment.toString());
                }
            }
            @Override
            public void onFailure(Call<AppointmentData> call, Throwable t) {
                Log.e("Error Response", t.toString());
            }
        });
    }
}