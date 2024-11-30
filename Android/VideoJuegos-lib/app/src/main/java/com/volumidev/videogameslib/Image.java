package com.volumidev.videogameslib;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("medium_url")
    private String mediumUrl;

    @SerializedName("screen_url")
    private String screenUrl;

    @SerializedName("screen_large_url")
    private String screenLargeUrl;

    @SerializedName("small_url")
    private String smallUrl;

    @SerializedName("super_url")
    private String superUrl;

    @SerializedName("thumb_url")
    private String thumbUrl;

    @SerializedName("tiny_url")
    private String tinyUrl;

    @SerializedName("original_url")
    private String originalUrl;

    @SerializedName("image_tags")
    private String imageTags;

    // Getters y Setters

    public String getIconUrl() {
        return iconUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public String getScreenUrl() {
        return screenUrl;
    }

    public String getScreenLargeUrl() {
        return screenLargeUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getSuperUrl() {
        return superUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getImageTags() {
        return imageTags;
    }

    // Setters omitidos por brevedad
}
