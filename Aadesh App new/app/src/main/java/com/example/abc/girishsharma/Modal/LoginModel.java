package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("CMSUserAuthenticationID")
    @Expose
    private String cMSUserAuthenticationID;
    @SerializedName("CMSUsername")
    @Expose
    private String cMSUsername;
    @SerializedName("CMSPassword")
    @Expose
    private String cMSPassword;
    @SerializedName("deviceToken")
    @Expose
    private Object deviceToken;
    @SerializedName("AppType")
    @Expose
    private Object appType;
    @SerializedName("platform")
    @Expose
    private Object platform;
    @SerializedName("AppceleratorUserID")
    @Expose
    private Object appceleratorUserID;
    @SerializedName("CMSUserDisplayname")
    @Expose
    private String cMSUserDisplayname;
    @SerializedName("LoginType")
    @Expose
    private Object loginType;
    @SerializedName("CMSUserParentID")
    @Expose
    private String cMSUserParentID;

    public String getCMSUserAuthenticationID() {
        return cMSUserAuthenticationID;
    }

    public void setCMSUserAuthenticationID(String cMSUserAuthenticationID) {
        this.cMSUserAuthenticationID = cMSUserAuthenticationID;
    }

    public String getCMSUsername() {
        return cMSUsername;
    }

    public void setCMSUsername(String cMSUsername) {
        this.cMSUsername = cMSUsername;
    }

    public String getCMSPassword() {
        return cMSPassword;
    }

    public void setCMSPassword(String cMSPassword) {
        this.cMSPassword = cMSPassword;
    }

    public Object getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(Object deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Object getAppType() {
        return appType;
    }

    public void setAppType(Object appType) {
        this.appType = appType;
    }

    public Object getPlatform() {
        return platform;
    }

    public void setPlatform(Object platform) {
        this.platform = platform;
    }

    public Object getAppceleratorUserID() {
        return appceleratorUserID;
    }

    public void setAppceleratorUserID(Object appceleratorUserID) {
        this.appceleratorUserID = appceleratorUserID;
    }

    public String getCMSUserDisplayname() {
        return cMSUserDisplayname;
    }

    public void setCMSUserDisplayname(String cMSUserDisplayname) {
        this.cMSUserDisplayname = cMSUserDisplayname;
    }

    public Object getLoginType() {
        return loginType;
    }

    public void setLoginType(Object loginType) {
        this.loginType = loginType;
    }

    public String getCMSUserParentID() {
        return cMSUserParentID;
    }

    public void setCMSUserParentID(String cMSUserParentID) {
        this.cMSUserParentID = cMSUserParentID;
    }
}
