package com.volumidev.videogameslib;
import com.google.gson.annotations.SerializedName;

/**
 * Clase que representa una imagen.
 */
public class ImageTag {

    @SerializedName("api_detail_url")
    private String apiDetailUrl;

    private String name;
    private int total;

    // Getters y Setters

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    // Setters omitidos por brevedad
}
