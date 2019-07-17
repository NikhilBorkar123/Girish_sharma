package com.example.abc.girishsharma.Modal;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message3 {
    @SerializedName("data")
    @Expose
    private List<Datum1> data = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("langstr")
    @Expose
    private String langstr;
    @SerializedName("appusrid")
    @Expose
    private String appusrid;
    @SerializedName("AppUserAgent")
    @Expose
    private String appUserAgent;
    @SerializedName("timestp")
    @Expose
    private Long timestp;
    @SerializedName("returl")
    @Expose
    private Object returl;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("pageno")
    @Expose
    private Integer pageno;
    @SerializedName("themecolor")
    @Expose
    private String themecolor;
    @SerializedName("fromtab")
    @Expose
    private Object fromtab;
    @SerializedName("appurl")
    @Expose
    private String appurl;
    @SerializedName("clientname")
    @Expose
    private String clientname;

    public List<Datum1> getData() {
        return data;
    }

    public void setData(List<Datum1> data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getLangstr() {
        return langstr;
    }

    public void setLangstr(String langstr) {
        this.langstr = langstr;
    }

    public String getAppusrid() {
        return appusrid;
    }

    public void setAppusrid(String appusrid) {
        this.appusrid = appusrid;
    }

    public String getAppUserAgent() {
        return appUserAgent;
    }

    public void setAppUserAgent(String appUserAgent) {
        this.appUserAgent = appUserAgent;
    }

    public Long getTimestp() {
        return timestp;
    }

    public void setTimestp(Long timestp) {
        this.timestp = timestp;
    }

    public Object getReturl() {
        return returl;
    }

    public void setReturl(Object returl) {
        this.returl = returl;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public String getThemecolor() {
        return themecolor;
    }

    public void setThemecolor(String themecolor) {
        this.themecolor = themecolor;
    }

    public Object getFromtab() {
        return fromtab;
    }

    public void setFromtab(Object fromtab) {
        this.fromtab = fromtab;
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }
}
