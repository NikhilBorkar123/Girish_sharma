package com.example.abc.girishsharma;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSes {
    private String CMSUsername,CMSUserAuthenticationID;
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
        CMSUsername = sharedPreferences.getString("CMSUsername","");
        return CMSUsername;

    }

    public void setCMSUsername(String CMSUsername) {
        this.CMSUsername = CMSUsername;
        sharedPreferences.edit().putString("CMSUsername",CMSUsername).apply();
    }

    public String getCMSUserAuthenticationID() {
        CMSUserAuthenticationID = sharedPreferences.getString("CMSUserAuthenticationID","");
        return CMSUserAuthenticationID;

    }

    public void setCMSUserAuthenticationID(String CMSUserAuthenticationID) {
        this.CMSUserAuthenticationID = CMSUserAuthenticationID;
        sharedPreferences.edit().putString("CMSUserAuthenticationID",CMSUserAuthenticationID).apply();
    }
}
