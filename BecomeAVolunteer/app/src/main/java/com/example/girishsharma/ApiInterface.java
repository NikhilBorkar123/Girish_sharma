package com.example.girishsharma;

import com.example.girishsharma.Modal.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("becomeAVolunteer")
    @FormUrlEncoded
    Call<Response> sendDetails(@Field("volunteerID") String volID,
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
}
