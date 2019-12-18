package com.example.abc.girishsharma.Modal;
import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class MessageVision {

    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("langstr")
    @Expose
    private Object langstr;
    @SerializedName("appusrid")
    @Expose
    private Integer appusrid;
    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("AppUserAgent")
    @Expose
    private Object appUserAgent;
    @SerializedName("timestp")
    @Expose
    private Integer timestp;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("themecolor")
    @Expose
    private String themecolor;
    @SerializedName("rsrathoreChange")
    @Expose
    private Integer rsrathoreChange;
    @SerializedName("profileimages")
    @Expose
    private List<Object> profileimages = null;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getLangstr() {
        return langstr;
    }

    public void setLangstr(Object langstr) {
        this.langstr = langstr;
    }

    public Integer getAppusrid() {
        return appusrid;
    }

    public void setAppusrid(Integer appusrid) {
        this.appusrid = appusrid;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Object getAppUserAgent() {
        return appUserAgent;
    }

    public void setAppUserAgent(Object appUserAgent) {
        this.appUserAgent = appUserAgent;
    }

    public Integer getTimestp() {
        return timestp;
    }

    public void setTimestp(Integer timestp) {
        this.timestp = timestp;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getThemecolor() {
        return themecolor;
    }

    public void setThemecolor(String themecolor) {
        this.themecolor = themecolor;
    }

    public Integer getRsrathoreChange() {
        return rsrathoreChange;
    }

    public void setRsrathoreChange(Integer rsrathoreChange) {
        this.rsrathoreChange = rsrathoreChange;
    }

    public List<Object> getProfileimages() {
        return profileimages;
    }

    public void setProfileimages(List<Object> profileimages) {
        this.profileimages = profileimages;
    }

}
