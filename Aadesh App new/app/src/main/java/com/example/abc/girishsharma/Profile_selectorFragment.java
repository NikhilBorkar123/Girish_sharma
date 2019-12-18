package com.example.abc.girishsharma;

import android.icu.util.Freezable;
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

public class Profile_selectorFragment extends Fragment {
    Message2 message;
    List<Datum> data;
    int position;
    String desc;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile_selector, container, false);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Example2> call4 = apiService.getAbout();
        Log.e("call4 is", "" + call4);
        call4.enqueue(new Callback<Example2>() {
            @Override
            public void onResponse(Call<Example2> call4, Response<Example2> response) {
                assert response.body() != null;
                message = response.body().getMessage();
                data = message.getData();
                if (getArguments() != null) {
                    position = getArguments().getInt("position");
                }
                textView=view.findViewById(R.id.profiletext);
                if (position == 0) {
                    desc = data.get(0).getCMSClientPersonalDescription();
                    textView.clearComposingText();
                    textView.setText(desc);
                    Log.e("personal"," "+desc);
                } else if (position == 1) {
                    desc = data.get(0).getCMSClientPoliticalDescription();
                    textView.clearComposingText();
                    textView.setText(desc);
                    Log.e("polotical"," "+desc);
                } else if (position == 2) {
                    desc = data.get(0).getCMSClientSocialDescription();
                    textView.clearComposingText();
                    textView.setText(desc);
                    Log.e("social"," "+desc);
                }
            }

            @Override
            public void onFailure(Call<Example2> call4, Throwable t) {
                // Log error here since request failed
                Log.e("about error", t.toString());
            }
        });
        return view;
    }
}
