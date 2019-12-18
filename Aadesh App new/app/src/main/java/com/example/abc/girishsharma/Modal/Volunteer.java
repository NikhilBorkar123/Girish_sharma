
package com.example.abc.girishsharma.Modal;

import java.util.List;

import com.example.abc.girishsharma.VolunteerDatum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volunteer {

    @SerializedName("data")
    @Expose
    private List<VolunteerDatum> data = null;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public List<VolunteerDatum> getData() {
        return data;
    }

    public void setData(List<VolunteerDatum> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
