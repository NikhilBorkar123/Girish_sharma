package com.example.abc.girishsharma;

import com.example.abc.girishsharma.Modal.ApiModelData;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.LoginModelData;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("frontend/clientquotes/50")
    Call<JsonObject> getClientCode();

    @GET("frontend/gallery/50")
    Call<Example> getGalleryList();

    @GET("frontend/events/35/ghj/23/hg/2147483647?show=maps")
    Call<JsonObject> getLatestEvents();

    @GET("frontend/about/35/abc/2/fgh/22")
    Call<Example2> getAbout();

    @GET("frontend/gallery/50")
    Call<Example> getimage();

    @GET("becomeAVolunteer")
    Call<ApiModelData> getDetails();

    @POST("becomeAVolunteer")
    @FormUrlEncoded
    Call<ApiModelData> sendDetails(@Field("volunteerID") String volID,
                               @Field("AppUserID") String appID,
                               @Field("fname") String fname,
                               @Field("lname") String lname,
                               @Field("profession") String prof,
                               @Field("email") String email,
                               @Field("phone") String phone,
                               @Field("address1") String adr1,
                               @Field("address2") String adr2,
                               @Field("city") String city,
                               @Field("state") String state,
                               @Field("pin") String pin,
                               @Field("CMSUserAuthenticationID") String cmID,
                               @Field("picture") String Pic);

    @POST("registerOrLogin")
    @FormUrlEncoded
    Call<LoginModelData> getLogin(@Field("CMSUsername") String name, @Field("CMSPassword") String pass);


}
