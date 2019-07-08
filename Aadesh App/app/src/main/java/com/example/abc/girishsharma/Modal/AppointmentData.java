package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppointmentData {
    @SerializedName("data")
    @Expose
    private Appointment data;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public Appointment getData() {
        return data;
    }

    public void setData(Appointment data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
