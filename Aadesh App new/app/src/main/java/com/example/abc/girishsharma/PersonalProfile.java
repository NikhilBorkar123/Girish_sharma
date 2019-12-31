package com.example.abc.girishsharma;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;
import com.example.abc.girishsharma.Modal.Datum;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.Message2;

import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalProfile extends Fragment {
    Message2 message;
    List<Datum> data;
    int position;
    String desc;
    TextView textView;
    public PersonalProfile(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_personal_profile, container, false);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Example2> call4 = apiService.getAbout();
        Log.e("call4 is", "" + call4);
        call4.enqueue(new Callback<Example2>() {
            @Override
            public void onResponse(Call<Example2> call4, Response<Example2> response) {
                assert response.body() != null;
                message = response.body().getMessage();
                data = message.getData();
                desc = data.get(0).getCMSClientPersonalDescription();
                String encodedHtml= Base64.encodeToString(desc.getBytes(),Base64.NO_PADDING);
                WebView myWebView = view.findViewById(R.id.webview);
                myWebView.loadData(encodedHtml, "text/html", "base64");
//                textView=view.findViewById(R.id.profiletext);
//                textView.setText(desc);
                Log.e("personal", " " + desc);
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {
                Log.e("Personal Profile Error", t.toString());
            }
        });
        return view;
    }
}