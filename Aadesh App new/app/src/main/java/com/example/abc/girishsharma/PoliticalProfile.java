package com.example.abc.girishsharma;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abc.girishsharma.Modal.Datum;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.Message2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PoliticalProfile extends Fragment {
    Message2 message;
    List<Datum> data;
    int position;
    String desc;
    TextView textView;
    public PoliticalProfile(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_political_profile, container, false);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Example2> call4 = apiService.getAbout();
        Log.e("call4 is", "" + call4);
        call4.enqueue(new Callback<Example2>() {
            @Override
            public void onResponse(Call<Example2> call4, Response<Example2> response) {
                assert response.body() != null;
                message = response.body().getMessage();
                data = message.getData();
                desc = data.get(0).getCMSClientPoliticalDescription();
                textView=view.findViewById(R.id.profiletext);
                textView.setText(desc);
                Log.e("political", " " + desc);
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {
                Log.e("Political Profile Error", t.toString());
            }
        });
        return view;
    }
}
