
package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("message4")
    @Expose
    private Message4 message4;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public Message4 getMessage() {
        return message4;
    }

    public void setMessage(Message4 message4) {
        this.message4 = message4;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
