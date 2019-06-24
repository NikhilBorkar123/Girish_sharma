package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.abc.girishsharma.Modal.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class VolunteerFragment extends Fragment {
    View view;
    private String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    TextInputLayout Fname, Lname, Email, Phone, Adr1, Adr2, City, State, Pincode;
    ImageView Image;
    Button submit;
    Spinner profession;

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


        profession = view.findViewById(R.id.spProf);
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
        Image = view.findViewById(R.id.image);
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
        Call<Response> call = apiInterface.sendDetails("1", "2", s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, "1", "abc.jpeg");
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
