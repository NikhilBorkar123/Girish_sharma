package com.example.abc.girishsharma;

import com.example.abc.girishsharma.Modal.ApiModelData;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.Example3;
import com.example.abc.girishsharma.Modal.LoginModelData;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @GET("frontend/clientquotes/50")
    Call<JsonObject> getClientCode();

    @GET("frontend/gallery/50")
    Call<Example> getGalleryList();

    @GET("frontend/initiatives/50/fg/21/agh/2147483647")
    Call<Example3> getInitiatives();

    @GET("frontend/events/35/ghj/23/hg/2147483647?show=maps")
    Call<JsonObject> getLatestEvents();

    @GET("frontend/about/35/abc/2/fgh/22")
    Call<Example2> getAbout();

    @GET("frontend/gallery/50")
    Call<Example> getimage();

    @GET("becomeAVolunteer")
    Call<ApiModelData> getDetails();

    @Multipart
    @POST("becomeAVolunteer")
    Call<ApiModelData> sendDetails(
            @Part("volunteerID") RequestBody volID,
            @Part("AppUserID") RequestBody appID,
            @Part("fname") RequestBody fname,
            @Part("lname") RequestBody lname,
            @Part("profession") RequestBody prof,
            @Part("email") RequestBody email,
            @Part("phone") RequestBody phone,
            @Part("address1") RequestBody adr1,
            @Part("address2") RequestBody adr2,
            @Part("city") RequestBody city,
            @Part("state") RequestBody state,
            @Part("pin") RequestBody pin,
            @Part("CMSUserAuthenticationID") RequestBody cmID,
            @Part MultipartBody.Part photo
            );

    @POST("registerOrLogin")
    @FormUrlEncoded
    Call<LoginModelData> getLogin(@Field("CMSUsername") String name, @Field("CMSPassword") String pass);


}
