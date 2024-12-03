package com.volumidev.videogameslib;
import com.google.gson.annotations.SerializedName;

/**
 * Clase que representa una plataforma.
 */
public class Platform {

    @SerializedName("api_detail_url")
    private String apiDetailUrl;

    private int id;
    private String name;

    @SerializedName("site_detail_url")
    private String siteDetailUrl;

    private String abbreviation;

    // Getters y Setters

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    // Setters omitidos por brevedad

}
