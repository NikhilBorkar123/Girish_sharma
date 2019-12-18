package com.example.abc.girishsharma.Modal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisionExample {

    @SerializedName("message")
    @Expose
    private MessageVision message;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public MessageVision getMessage() {
        return message;
    }

    public void setMessage(MessageVision message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}

