package com.example.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiModelData {
    @SerializedName("data")
    @Expose
    private ApiModel data;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public ApiModel getData() {
        return data;
    }

    public void setData(ApiModel data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
