package com.example.abc.girishsharma;

import com.example.abc.girishsharma.Modal.AppointmentData;
import com.example.abc.girishsharma.Modal.Comment;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.LoginModelData;
import com.example.abc.girishsharma.Modal.UpdateProfileData;
import com.example.abc.girishsharma.Modal.VisionExample;
import com.example.abc.girishsharma.Modal.Volunteer;
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

    @GET("frontend/events/35/ghj/23/hg/2147483647?show=maps")
    Call<JsonObject> getLatestEvents();

    @GET("frontend/gallery/50")
    Call<Example> getGalleryList();

    @GET("frontend/about/35/abc/2/fgh/22")
    Call<Example2> getAbout();

    @GET("frontend/gallery/50")
    Call<Example> getimage();

    @GET("becomeAVolunteer")
    Call<Volunteer> getDetails();

    @GET("frontend/complaints/comments/2/35/avg/3/abc/3")
    Call<Comment> getComment();

    @GET("frontend/vision/50")
    Call<VisionExample> getVision();

    @Multipart
    @POST("becomeAVolunteer")
    Call<JsonObject> sendDetails(@Part("volunteerID") RequestBody volID,
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
                                 @Part MultipartBody.Part Pic
//                                @Part("file\"; filename=\"pp.png\" ") RequestBody file
    );

    @FormUrlEncoded // annotation used in POST type requests
    @POST("AddUpdateUserDetails")
    Call<JsonObject> shareDetails(
            @Field("AppUserID") String appUserId,
            @Field("Fname") String FirstName,
            @Field("Lname") String LastName,
            @Field("Gender") String gender,
            @Field("BloodGroup") String bloodGroup,
            @Field("DOB") String Dob,
            @Field("DOA") String Doa,
            @Field("Profession") String profession,
            @Field("Phone") String phoneNo,
            @Field("email") String email,
            @Field("address1") String address,
            @Field("address2") String address2,
            @Field("city") String city,
            @Field("pin") String pin,
            @Field("state") String state,
            @Field("CMSUserAuthenticationID") String CMSId,
            @Field("members") String members,
            @Field("Mname") String mname,
            @Field("Name") String name,
            @Field("memberid") String memberId,
            @Field("Relation") String relation
    );

    @POST("registerOrLogin")
    @FormUrlEncoded
    Call<LoginModelData> getLogin(@Field("CMSUsername") String name, @Field("CMSPassword") String pass);

    @POST("AppointmentRequest")
    @FormUrlEncoded
    Call<AppointmentData> sendAppDetails(@Field("appointmentID") String appID,
                                         @Field("AppUserID") String userID,
                                         @Field("name") String name,
                                         @Field("profession") String prof,
                                         @Field("email") String email,
                                         @Field("phone") String phone,
                                         @Field("address1") String adr1,
                                         @Field("address2") String adr2,
                                         @Field("city") String city,
                                         @Field("state") String state,
                                         @Field("pin") String pin,
                                         @Field("purpose") String purpose,
                                         @Field("referenceName") String rname,
                                         @Field("referencePost") String rpost,
                                         @Field("referencePhone") String rphone,
                                         @Field("CMSUserAuthenticationID") String cmsID
    );

    @POST("AddUpdateComplaint")
    @FormUrlEncoded
    Call<JsonObject> postIssue(
            @Field("AppUserID") String appID,
            @Field("ClientComplaintAndSuggestionID") String complaintSuggestionId,
            @Field("CMSUserAuthenticationID") String cmsID,
            @Field("ClientDepartmentID") String clientDepartmentID,
            @Field("ComplaintLat") String complaintLat,
            @Field("ComplaintLong") String complaintLong,
            @Field("Title") String title,
            @Field("Description") String desc,
            @Field("Address") String address,
            @Field("DepartmentName") String deptName
    );

    @POST("LoginUser")
    @FormUrlEncoded
    Call<LoginModelData> sendLogin(@Field("MobileOrEmail") String uname,
                                   @Field("Password") String pass,
                                   @Field("CMSUserAuthenticationID") String cmsID
    );

    @POST("UpdateProfile")
    @Multipart
    Call<UpdateProfileData> sendUpdate(
            @Part ("Appuserid") RequestBody id,
            @Part("Name")RequestBody name,
            @Part("email")RequestBody email,
            @Part("mobileno")RequestBody mobno,
            @Part("CMSUserAuthenticationID")RequestBody cmsid,
            @Part MultipartBody.Part Pic
    );

}
