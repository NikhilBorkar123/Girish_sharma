
package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum2 {

    @SerializedName("ComplaintCommentText")
    @Expose
    private String complaintCommentText;
    @SerializedName("ShowtoPublic")
    @Expose
    private String showtoPublic;
    @SerializedName("CMSUserAuthenticationID")
    @Expose
    private Object cMSUserAuthenticationID;
    @SerializedName("ComplaintCommentDate")
    @Expose
    private String complaintCommentDate;
    @SerializedName("ComplaintCommentByinternalexternal")
    @Expose
    private String complaintCommentByinternalexternal;
    @SerializedName("appusername")
    @Expose
    private String appusername;

    public String getComplaintCommentText() {
        return complaintCommentText;
    }

    public void setComplaintCommentText(String complaintCommentText) {
        this.complaintCommentText = complaintCommentText;
    }

    public String getShowtoPublic() {
        return showtoPublic;
    }

    public void setShowtoPublic(String showtoPublic) {
        this.showtoPublic = showtoPublic;
    }

    public Object getCMSUserAuthenticationID() {
        return cMSUserAuthenticationID;
    }

    public void setCMSUserAuthenticationID(Object cMSUserAuthenticationID) {
        this.cMSUserAuthenticationID = cMSUserAuthenticationID;
    }

    public String getComplaintCommentDate() {
        return complaintCommentDate;
    }

    public void setComplaintCommentDate(String complaintCommentDate) {
        this.complaintCommentDate = complaintCommentDate;
    }

    public String getComplaintCommentByinternalexternal() {
        return complaintCommentByinternalexternal;
    }

    public void setComplaintCommentByinternalexternal(String complaintCommentByinternalexternal) {
        this.complaintCommentByinternalexternal = complaintCommentByinternalexternal;
    }

    public String getAppusername() {
        return appusername;
    }

    public void setAppusername(String appusername) {
        this.appusername = appusername;
    }

}
