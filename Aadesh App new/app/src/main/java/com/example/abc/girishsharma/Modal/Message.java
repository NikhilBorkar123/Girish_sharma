package com.example.abc.girishsharma.Modal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("dataindiv")
    @Expose
    private List<Object> dataindiv;
    @SerializedName("dataimg")
    @Expose
    private List<Dataimg> dataimg;
    @SerializedName("datavid")
    @Expose
    private List<Object> datavid;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("langstr")
    @Expose
    private String langstr;
    @SerializedName("appusrid")
    @Expose
    private Integer appusrid;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("AppUserAgent")
    @Expose
    private String appUserAgent;
    @SerializedName("timestp")
    @Expose
    private Long timestp;
    @SerializedName("show")
    @Expose
    private Object show;
    @SerializedName("themecolor")
    @Expose
    private String themecolor;
    @SerializedName("appurl")
    @Expose
    private String appurl;
    @SerializedName("clientname")
    @Expose
    private String clientname;

    public List<Object> getDataindiv() {
        return dataindiv;
    }

    public void setDataindiv(List<Object> dataindiv) {
        this.dataindiv = dataindiv;
    }

    public List<Dataimg> getDataimg() {
        return dataimg;
    }

    public void setDataimg(List<Dataimg> dataimg) {
        this.dataimg = dataimg;
    }

    public List<Object> getDatavid() {
        return datavid;
    }

    public void setDatavid(List<Object> datavid) {
        this.datavid = datavid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAppusrid() {
        return appusrid;
    }

    public void setAppusrid(Integer appusrid) {
        this.appusrid = appusrid;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public Object getShow() {
        return show;
    }

    public void setShow(Object show) {
        this.show = show;
    }

    public String getThemecolor() {
        return themecolor;
    }

    public void setThemecolor(String themecolor) {
        this.themecolor = themecolor;
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
