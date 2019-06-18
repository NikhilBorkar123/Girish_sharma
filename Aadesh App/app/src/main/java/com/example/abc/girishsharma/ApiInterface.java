package com.example.abc.girishsharma;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("clientquotes/35/abc/2/tru/2147483647")
    Call<JsonObject> getClientCode();

    @GET("events/35/ghj/23/hg/2147483647?show=maps")
    Call<JsonObject> getLatestEvents();
}
