package com.example.abc.girishsharma;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

public class ShareDetailsFragment extends Fragment implements View.OnClickListener {
    View view;
    EditText UserId, firstname, lastname, email, middlename, phoneno, DOB, DOA, DOB2, address, address2, city, pincode, state,name,memberId,relation;
    Button submit;
    String gen, prof, blood, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21;
    DatePickerDialog datePickerDialog1, datePickerDialog2, datePickerDialog3;
    Spinner gender, profession, bloodgrp;
    AwesomeValidation awesomeValidation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_share_details, container, false);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        AwesomeValidation mAwesomeValidation = new AwesomeValidation(COLORATION);
        mAwesomeValidation.setColor( Color.YELLOW);
        //Bind views with their ids
        findViews();
        //Set listeners of views
        setViewActions();
        view.findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValidation();
                getData();
                submitForm();
                // loading spinner
//                ImageView loading=view.findViewById(R.id.imageView9);
//                AnimationDrawable animationDrawable = (AnimationDrawable) loading.getDrawable();
//                loading.setVisibility(View.VISIBLE);
//                animationDrawable.start();
            }
        });

//        submitForm();
        // Spinner element1
        Spinner spinner1 = view.findViewById(R.id.spGender);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Female");
        categories.add("Male");
        categories.add("Third Gender");

        // Creating adapter for spinner1
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button1
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s4 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner element2
        Spinner spinner2 = view.findViewById(R.id.spProf);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Student");
        categories2.add("None");
        categories2.add("Government Service");
        categories2.add("Private Service");

        // Creating adapter for spinner2
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button2
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s8 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner element3
        Spinner spinner3 = (Spinner) view.findViewById(R.id.spBloodGrp);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("O+");
        categories3.add("O-");
        categories3.add("A+");
        categories3.add("A-");
        categories3.add("B+");
        categories3.add("B-");
        categories3.add("AB+");
        categories3.add("AB-");

        // Creating adapter for spinner3
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button3
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner3.setAdapter(dataAdapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s5 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Create DatePickerDialog to show a calendar to user to select birthdate
        prepareDatePickerDialog();
        return view;
    }

    private void findViews() {
        firstname = view.findViewById(R.id.etFirstName);
        lastname = view.findViewById(R.id.etLastName);
        DOB = view.findViewById(R.id.birthday);
        DOA = view.findViewById(R.id.etDOA);
        phoneno = view.findViewById(R.id.etPhoneNo);
        email = view.findViewById(R.id.etEmail);
        address = view.findViewById(R.id.etAddress);
        address2 = view.findViewById(R.id.etAddress2);
        city = view.findViewById(R.id.etcity);
        pincode = view.findViewById(R.id.etPincode);
        state = view.findViewById(R.id.etState);
        middlename = view.findViewById(R.id.etMidName);
        name=view.findViewById(R.id.etName);
        DOB2=view.findViewById(R.id.birthday2);
        relation=view.findViewById(R.id.etRelation);
        setValidation();
    }
    private void getData(){
        s1 = "50";
        s2 = firstname.getText().toString();
        s3 = lastname.getText().toString();
        s6 = DOB.getText().toString();
        s7 = DOA.getText().toString();
        s9 = phoneno.getText().toString();
        s10 = email.getText().toString();
        s11 = address.getText().toString();
        s12 = address2.getText().toString();
        s13 = city.getText().toString();
        s14 = pincode.getText().toString();
        s15 = state.getText().toString();
        s16="50";
        s17="";
        s18 = middlename.getText().toString();
        s19=name.getText().toString();
        s20="1";
        s21=relation.getText().toString();
        setValidation();
    }
    private void submitForm() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiInterface.shareDetails(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21);
        Log.e("share ur details call:", "" + call);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject shareDetails = response.body();
                Log.e("shareurdetails res", shareDetails + "");
                String success_message = shareDetails.get("success").getAsString();
                Log.e("the success message is", success_message + "");
//                ImageView loading=view.findViewById(R.id.imageView9);
                if (shareDetails != null) {
                    if (success_message.equals("true")) {
//                        animationDrawable.stop();
//                        loading.setVisibility(View.INVISIBLE);
                        Toast.makeText(getContext(), "Submit data successfully...", Toast.LENGTH_SHORT).show();
                        new AlertDialog.Builder(getContext())
                                .setTitle("You successfully shared your Details!")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                                    }
                                })
                                .show();
                    } else {
//                        animationDrawable.stop();
//                        loading.setVisibility(View.INVISIBLE);
                        Toast.makeText(getContext(), "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert shareDetails != null;
                    Log.v("Response error", shareDetails.toString());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void setValidation() {
        awesomeValidation.addValidation(getActivity(), R.id.etFirstName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.etMidName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.etLastName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.etEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(getActivity(), R.id.etPhoneNo, "^[+]?[0-9]{10,13}$", R.string.mobileerror);
    }

    private void setViewActions() {
        DOB.setOnClickListener(this);
        DOB2.setOnClickListener(this);
        DOA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.birthday:
                datePickerDialog1.show();
                //Show a Calendar
                break;
            case R.id.birthday2:
                datePickerDialog3.show();
                //Show a Calendar
                break;
            case R.id.etDOA:
                datePickerDialog2.show();
                //Show a Calendar
                break;
            case R.id.btnSubmit:
                //show toast with typed and selected values
                break;
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void prepareDatePickerDialog() {
        //Get current date
        Calendar calendar = Calendar.getInstance();

        //Create datePickerDialog with initial date which is current and decide what happens when a date is selected.
        datePickerDialog1 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change  dateOfBirth's text and dismiss dialog.
                DOB.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                datePickerDialog1.dismiss();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog2 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change  dateOfBirth's text and dismiss dialog.
                DOA.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                datePickerDialog2.dismiss();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog3 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change  dateOfBirth's text and dismiss dialog.
                DOB2.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                datePickerDialog3.dismiss();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
}
