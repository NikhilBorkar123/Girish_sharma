package com.example.abc.girishsharma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.LoginModel;
import com.example.abc.girishsharma.Modal.LoginModelData;
import com.google.gson.Gson;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    View view;
    TextInputLayout CMSuser, CMSpass;
    Button log;
    LoginModel loginModel;
    String checkSuccess;
    String cmsID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        cmsID = getString(R.string.CMSUserAuthenticationID);
        CMSuser = view.findViewById(R.id.uname);
        CMSpass = view.findViewById(R.id.upass);
        log = view.findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = CMSuser.getEditText().getText().toString();
                String Pass = CMSpass.getEditText().getText().toString();
                Log.e("Error", "USER AND PASS" + Name + Pass);
                if (Login(Name, Pass)) {
                    performLogin(Name, Pass, cmsID);
                }
            }
        });
        return view;
    }

    private boolean Login(String name, String pass) {
        if (name == null || name.trim().length() == 0) {
            Toast.makeText(getContext(), "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pass == null || pass.trim().length() == 0) {
            Toast.makeText(getContext(), "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    private void performLogin(String name, String pass, String cmID) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginModelData> call = apiInterface.sendLogin(name, pass, cmID);
        call.enqueue(new Callback<LoginModelData>() {
            @Override
            public void onResponse(Call<LoginModelData> call, Response<LoginModelData> response) {
                loginModel = response.body().getData();
                checkSuccess = response.body().getSuccess().toString();
                Log.e("Err check", checkSuccess);
                if (checkSuccess.equals("true")) {
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    //User data...
//                    String AppUserID = loginModel.getAppUserID();
//                    String AppUserFirstname = loginModel.getAppUserFirstname();
//                    String AppUserlastname = loginModel.getAppUserLastname();
//                    String AppUserEmail = loginModel.getAppUserEmail();
//                    String AppUserPhone = loginModel.getApUserPhoneNumber();
//                    String AppUserProfile = loginModel.getAppUserProfileImage();
//                    String verified = loginModel.getIsAccountVerified();

                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                } else {
                    Toast.makeText(getContext(), "Incorrect username and password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModelData> call, Throwable t) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }
}
