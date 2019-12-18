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
    TextInputLayout CMSuser,CMSpass;
    Button log;
    LoginModel loginModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login,container,false);

        CMSuser = view.findViewById(R.id.uname);
        CMSpass = view.findViewById(R.id.upass);
        log = view.findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = CMSuser.getEditText().getText().toString();
                String Pass = CMSpass.getEditText().getText().toString();
                if(Login(Name,Pass)){
                    performLogin(Name,Pass);
                }
            }
        });
        return view;
    }

    private boolean Login(String name, String pass){
        if(name == null || name.trim().length() == 0){
            Toast.makeText(getContext(), "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass == null || pass.trim().length() == 0){
            Toast.makeText(getContext(), "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    private void performLogin(String name,String pass){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginModelData> call = apiInterface.getLogin(name,pass);
        call.enqueue(new Callback<LoginModelData>() {
            @Override
            public void onResponse(Call<LoginModelData> call, Response<LoginModelData> response) {
                    loginModel = response.body().getData();
                    if (loginModel.equals("true")) {
                        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(),HomeFragment.class));
                    } else {
                        Toast.makeText(getContext(), "Incorrect username and password", Toast.LENGTH_SHORT).show();
                    }
            }
            @Override
            public void onFailure(Call<LoginModelData> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
