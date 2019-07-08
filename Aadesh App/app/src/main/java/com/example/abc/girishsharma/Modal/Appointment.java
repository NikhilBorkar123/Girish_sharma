package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appointment {
    @SerializedName("appointmentID")
    @Expose
    private String appointmentID;
    @SerializedName("AppUserID")
    @Expose
    private String appUserID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("referenceName")
    @Expose
    private String referenceName;
    @SerializedName("referencePost")
    @Expose
    private String referencePost;
    @SerializedName("referencePhone")
    @Expose
    private String referencePhone;
    @SerializedName("CMSUserAuthenticationID")
    @Expose
    private String cMSUserAuthenticationID;

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppUserID() {
        return appUserID;
    }

    public void setAppUserID(String appUserID) {
        this.appUserID = appUserID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferencePost() {
        return referencePost;
    }

    public void setReferencePost(String referencePost) {
        this.referencePost = referencePost;
    }

    public String getReferencePhone() {
        return referencePhone;
    }

    public void setReferencePhone(String referencePhone) {
        this.referencePhone = referencePhone;
    }

    public String getCMSUserAuthenticationID() {
        return cMSUserAuthenticationID;
    }

    public void setCMSUserAuthenticationID(String cMSUserAuthenticationID) {
        this.cMSUserAuthenticationID = cMSUserAuthenticationID;
    }
}
