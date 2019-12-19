
package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Message4 {

    @SerializedName("data")
    @Expose
    private List<Datum2> data ;
    @SerializedName("unifiedToHtml")
    @Expose
    private String unifiedToHtml;
    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("appusrid")
    @Expose
    private Integer appusrid;
    @SerializedName("langstr")
    @Expose
    private String langstr;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("AppUserAgent")
    @Expose
    private String appUserAgent;
    @SerializedName("timestp")
    @Expose
    private Integer timestp;
    @SerializedName("backurl")
    @Expose
    private Object backurl;
    @SerializedName("returl")
    @Expose
    private Object returl;
    @SerializedName("source")
    @Expose
    private Object source;
    @SerializedName("frommy")
    @Expose
    private Object frommy;
    @SerializedName("themecolor")
    @Expose
    private String themecolor;

    public List<Datum2> getData() {
        return data;
    }

    public void setData(List<Datum2> data) {
        this.data = data;
    }

    public String getUnifiedToHtml() {
        return unifiedToHtml;
    }

    public void setUnifiedToHtml(String unifiedToHtml) {
        this.unifiedToHtml = unifiedToHtml;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getAppusrid() {
        return appusrid;
    }

    public void setAppusrid(Integer appusrid) {
        this.appusrid = appusrid;
    }

    public String getLangstr() {
        return langstr;
    }

    public void setLangstr(String langstr) {
        this.langstr = langstr;
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

    public String getAppUserAgent() {
        return appUserAgent;
    }

    public void setAppUserAgent(String appUserAgent) {
        this.appUserAgent = appUserAgent;
    }

    public Integer getTimestp() {
        return timestp;
    }

    public void setTimestp(Integer timestp) {
        this.timestp = timestp;
    }

    public Object getBackurl() {
        return backurl;
    }

    public void setBackurl(Object backurl) {
        this.backurl = backurl;
    }

    public Object getReturl() {
        return returl;
    }

    public void setReturl(Object returl) {
        this.returl = returl;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getFrommy() {
        return frommy;
    }

    public void setFrommy(Object frommy) {
        this.frommy = frommy;
    }

    public String getThemecolor() {
        return themecolor;
    }

    public void setThemecolor(String themecolor) {
        this.themecolor = themecolor;
    }

}
