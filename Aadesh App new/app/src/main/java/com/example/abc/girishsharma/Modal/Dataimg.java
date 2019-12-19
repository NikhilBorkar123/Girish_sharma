package com.example.abc.girishsharma.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dataimg {

    @SerializedName("ClientGalleryID")
    @Expose
    private String clientGalleryID;
    @SerializedName("CMSUserAuthenticationID")
    @Expose
    private String cMSUserAuthenticationID;
    @SerializedName("ClientMediaTitle")
    @Expose
    private String clientMediaTitle;
    @SerializedName("ShortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("LongDescription")
    @Expose
    private String longDescription;
    @SerializedName("ClientMediaPath")
    @Expose
    private String clientMediaPath;
    @SerializedName("ClientMediaType")
    @Expose
    private String clientMediaType;
    @SerializedName("IsShowntoPublic")
    @Expose
    private String isShowntoPublic;
    @SerializedName("UploadedDate")
    @Expose
    private String uploadedDate;
    @SerializedName("CountComment")
    @Expose
    private String countComment;
    @SerializedName("GalleryCommentText")
    @Expose
    private Object galleryCommentText;
    @SerializedName("GalleryCommentDate")
    @Expose
    private Object galleryCommentDate;
    @SerializedName("GalleryCommentBy")
    @Expose
    private Object galleryCommentBy;
    @SerializedName("appusername")
    @Expose
    private Object appusername;
    @SerializedName("CountYesComment")
    @Expose
    private int countYesComment;

    public String getClientGalleryID() {
        return clientGalleryID;
    }

    public void setClientGalleryID(String clientGalleryID) {
        this.clientGalleryID = clientGalleryID;
    }

    public String getCMSUserAuthenticationID() {
        return cMSUserAuthenticationID;
    }

    public void setCMSUserAuthenticationID(String cMSUserAuthenticationID) {
        this.cMSUserAuthenticationID = cMSUserAuthenticationID;
    }

    public String getClientMediaTitle() {
        return clientMediaTitle;
    }

    public void setClientMediaTitle(String clientMediaTitle) {
        this.clientMediaTitle = clientMediaTitle;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getClientMediaPath() {
        return clientMediaPath;
    }

    public void setClientMediaPath(String clientMediaPath) {
        this.clientMediaPath = clientMediaPath;
    }

    public String getClientMediaType() {
        return clientMediaType;
    }

    public void setClientMediaType(String clientMediaType) {
        this.clientMediaType = clientMediaType;
    }

    public String getIsShowntoPublic() {
        return isShowntoPublic;
    }

    public void setIsShowntoPublic(String isShowntoPublic) {
        this.isShowntoPublic = isShowntoPublic;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getCountComment() {
        return countComment;
    }

    public void setCountComment(String countComment) {
        this.countComment = countComment;
    }

    public Object getGalleryCommentText() {
        return galleryCommentText;
    }

    public void setGalleryCommentText(Object galleryCommentText) {
        this.galleryCommentText = galleryCommentText;
    }

    public Object getGalleryCommentDate() {
        return galleryCommentDate;
    }

    public void setGalleryCommentDate(Object galleryCommentDate) {
        this.galleryCommentDate = galleryCommentDate;
    }

    public Object getGalleryCommentBy() {
        return galleryCommentBy;
    }

    public void setGalleryCommentBy(Object galleryCommentBy) {
        this.galleryCommentBy = galleryCommentBy;
    }

    public Object getAppusername() {
        return appusername;
    }

    public void setAppusername(Object appusername) {
        this.appusername = appusername;
    }

    public int getCountYesComment() {
        return countYesComment;
    }

    public void setCountYesComment(int countYesComment) {
        this.countYesComment = countYesComment;
    }

    public int countlikes(int like){
        countYesComment+=1;
        return countYesComment;
    }
}
