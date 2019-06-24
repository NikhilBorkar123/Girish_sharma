package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiModelData {
    @SerializedName("data")
    @Expose
    private List<ApiModel> data;
    @SerializedName("success")
    @Expose
    private Boolean success;



    public boolean getSuccess() {
        return success;
    }

    public List<ApiModel> getData() {
        return data;
    }

    public void setData(List<ApiModel> data) {
        this.data = data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
