package com.example.abc.girishsharma;

public class Appointment {

    private static  final String url = "http://iamapp.incubatorsdwnmt.com/api/AppointmentRequest";
    private String appointmentID;
    private String AooUserID;
    private String name;
    private String profession;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String pin;
    private String purpose;
    private String referenceName;
    private String referencePost;
    private String referencePhone;
    private String CMSUserAuthenticationID;

    public Appointment(String appointmentID, String aooUserID, String name, String profession, String email, String phone, String address1, String address2, String city, String state, String pin, String purpose, String referenceName, String referencePost, String referencePhone, String CMSUserAuthenticationID) {
        this.appointmentID = appointmentID;
        AooUserID = aooUserID;
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.purpose = purpose;
        this.referenceName = referenceName;
        this.referencePost = referencePost;
        this.referencePhone = referencePhone;
        this.CMSUserAuthenticationID = CMSUserAuthenticationID;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String getAooUserID() {
        return AooUserID;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPin() {
        return pin;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public String getReferencePost() {
        return referencePost;
    }

    public String getReferencePhone() {
        return referencePhone;
    }

    public String getCMSUserAuthenticationID() {
        return CMSUserAuthenticationID;
    }
}
