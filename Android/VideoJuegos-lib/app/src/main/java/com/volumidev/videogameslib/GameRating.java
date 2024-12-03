package com.volumidev.videogameslib;
import com.google.gson.annotations.SerializedName;

/**
 * Clase que representa el Rating de juego de la respuesta de la API
 */
public class GameRating {

    @SerializedName("api_detail_url")
    private String apiDetailUrl;

    private int id;
    private String name;

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

    // Setters omitidos por brevedad
}

