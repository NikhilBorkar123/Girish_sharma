package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.Datum;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.Message2;
import com.example.abc.girishsharma.Modal.MessageVision;
import com.example.abc.girishsharma.Modal.VisionExample;
import com.google.gson.JsonObject;

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
        Call<JsonObject> call5 = apiService.getVision();
        Log.e("call vision is", "" + call5);
        call5.enqueue(new Callback<JsonObject>() {
            public void onResponse(Call<JsonObject> call5, Response<JsonObject> response) {
                assert response.body() != null;
                JsonObject object=response.body();
                data = object.get("message").getAsJsonObject().get("data").getAsString();
//                Log.e("message",messageVision.toString());
//                data = messageVision.getData().toString();
                Log.e("my_vision",data);
//                textView=view.findViewById(R.id.nav_my_vision);
//                textView.setText(data);
                String encodedHtml= Base64.encodeToString(data.getBytes(),Base64.NO_PADDING);
                WebView myWebView = view.findViewById(R.id.webview);
                myWebView.loadData(encodedHtml, "text/html", "base64");

            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
        return view;
    }
}