package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.Datum;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.Message2;
import com.example.abc.girishsharma.Modal.MessageVision;
import com.example.abc.girishsharma.Modal.VisionExample;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyVisionFragment extends Fragment {
    MessageVision messageVision;
    String data;
    int position;
    String desc;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my_vision, container, false);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<VisionExample> call5 = apiService.getVision();
        Log.e("call vision is", "" + call5);
        Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
        call5.enqueue(new Callback<VisionExample>() {
            public void onResponse(Call<VisionExample> call5, Response<VisionExample> response) {
                assert response.body() != null;
                messageVision = response.body().getMessage();
                data = messageVision.getData();
                Log.e("my_vision",data);
                textView=view.findViewById(R.id.nav_my_vision);
                textView.setText("Hello");

            }
            @Override
            public void onFailure(Call<VisionExample> call, Throwable t) {

            }
        });
        return view;
    }
}