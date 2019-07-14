package com.example.abc.girishsharma;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSes {
    private String CMSUsername,CMSUserAuthenticationID,AppUserID;
    private SharedPreferences sharedPreferences;
    private Context context;

    public UserSes(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
    }
    public void removeUser(){
        sharedPreferences.edit().clear().apply();
    }

    public String getCMSUsername(){
        CMSUsername = sharedPreferences.getString("CMSUsername","Addy@123");
        return CMSUsername;

    }

    public void setCMSUsername(String CMSUsername) {
        this.CMSUsername = CMSUsername;
        sharedPreferences.edit().putString("CMSUsername",CMSUsername).apply();
    }

    public String getCMSUserAuthenticationID() {
        CMSUserAuthenticationID = sharedPreferences.getString("CMSUserAuthenticationID","50");
        return CMSUserAuthenticationID;

    }

    public void setCMSUserAuthenticationID(String CMSUserAuthenticationID) {
        this.CMSUserAuthenticationID = CMSUserAuthenticationID;
        sharedPreferences.edit().putString("CMSUserAuthenticationID",CMSUserAuthenticationID).apply();
    }

    public String getAppUserID(){
        AppUserID = sharedPreferences.getString("AppUserID","");
        return AppUserID;
    }
    public void setAppUserID(String AppUserID){
        this.AppUserID = AppUserID;
        sharedPreferences.edit().putString("AppUserID",AppUserID).apply();
    }
}
