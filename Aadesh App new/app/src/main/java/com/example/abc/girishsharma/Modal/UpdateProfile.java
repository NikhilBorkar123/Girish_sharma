package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfile {
    @SerializedName("AppUserID")
    @Expose
    private String appUserID;
    @SerializedName("AppUserFirstname")
    @Expose
    private String appUserFirstname;
    @SerializedName("AppUserLastname")
    @Expose
    private String appUserLastname;
    @SerializedName("AppUserEmail")
    @Expose
    private String appUserEmail;
    @SerializedName("ApUserPhoneNumber")
    @Expose
    private String apUserPhoneNumber;
    @SerializedName("AppUserProfileImage")
    @Expose
    private String appUserProfileImage;
    @SerializedName("IsAccountVerified")
    @Expose
    private String isAccountVerified;

    public String getAppUserID() {
        return appUserID;
    }

    public void setAppUserID(String appUserID) {
        this.appUserID = appUserID;
    }

    public String getAppUserFirstname() {
        return appUserFirstname;
    }

    public void setAppUserFirstname(String appUserFirstname) {
        this.appUserFirstname = appUserFirstname;
    }

    public String getAppUserLastname() {
        return appUserLastname;
    }

    public void setAppUserLastname(String appUserLastname) {
        this.appUserLastname = appUserLastname;
    }

    public String getAppUserEmail() {
        return appUserEmail;
    }

    public void setAppUserEmail(String appUserEmail) {
        this.appUserEmail = appUserEmail;
    }

    public String getApUserPhoneNumber() {
        return apUserPhoneNumber;
    }

    public void setApUserPhoneNumber(String apUserPhoneNumber) {
        this.apUserPhoneNumber = apUserPhoneNumber;
    }

    public String getAppUserProfileImage() {
        return appUserProfileImage;
    }

    public void setAppUserProfileImage(String appUserProfileImage) {
        this.appUserProfileImage = appUserProfileImage;
    }

    public String getIsAccountVerified() {
        return isAccountVerified;
    }

    public void setIsAccountVerified(String isAccountVerified) {
        this.isAccountVerified = isAccountVerified;
    }
}
