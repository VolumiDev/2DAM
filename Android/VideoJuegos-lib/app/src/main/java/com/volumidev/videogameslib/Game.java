package com.volumidev.videogameslib;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Game {

    private int favorite_id;
    private String aliases;

    @SerializedName("api_detail_url")
    private String apiDetailUrl;

    @SerializedName("date_added")
    private String dateAdded;

    @SerializedName("date_last_updated")
    private String dateLastUpdated;

    private String deck;
    private String description;

    @SerializedName("expected_release_day")
    private Integer expectedReleaseDay;

    @SerializedName("expected_release_month")
    private Integer expectedReleaseMonth;

    @SerializedName("expected_release_quarter")
    private Integer expectedReleaseQuarter;

    @SerializedName("expected_release_year")
    private Integer expectedReleaseYear;

    private String guid;
    private int id;

    private Image image;

    @SerializedName("image_tags")
    private List<ImageTag> imageTags;

    private String name;

    @SerializedName("number_of_user_reviews")
    private int numberOfUserReviews;

    @SerializedName("original_game_rating")
    private List<GameRating> originalGameRating;

    @SerializedName("original_release_date")
    private String originalReleaseDate;

    private List<Platform> platforms;

    @SerializedName("site_detail_url")
    private String siteDetailUrl;

    @SerializedName("resource_type")
    private String resourceType;

    // Getters y Setters

    public String getAliases() {
        return aliases;
    }

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public String getDeck() {
        return deck;
    }

    public String getDescription() {
        return description;
    }

    public Integer getExpectedReleaseDay() {
        return expectedReleaseDay;
    }

    public Integer getExpectedReleaseMonth() {
        return expectedReleaseMonth;
    }

    public Integer getExpectedReleaseQuarter() {
        return expectedReleaseQuarter;
    }

    public Integer getExpectedReleaseYear() {
        return expectedReleaseYear;
    }

    public String getGuid() {
        return guid;
    }

    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<ImageTag> getImageTags() {
        return imageTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNumberOfUserReviews() {
        return numberOfUserReviews;
    }

    public List<GameRating> getOriginalGameRating() {
        return originalGameRating;
    }

    public String getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public String getResourceType() {
        return resourceType;
    }


    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }
}
