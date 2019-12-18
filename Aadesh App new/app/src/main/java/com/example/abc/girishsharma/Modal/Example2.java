package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example2 {

    @SerializedName("message")
    @Expose
    private Message2 message;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public Message2 getMessage() {
        return message;
    }

    public void setMessage(Message2 message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
