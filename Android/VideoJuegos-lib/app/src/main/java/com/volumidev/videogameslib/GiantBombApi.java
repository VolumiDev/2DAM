package com.volumidev.videogameslib;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interfaz que define las operaciones de la API de Giant Bomb.
 */
public interface GiantBombApi {

    @GET("search/")
    Call<ApiResponse<Game>> searchGames(
            @Query("query") String query,
            @Query("resources") String resources,
            @Query("api_key") String apiKey,
            @Query("format") String format,
            @Query("limit") int limit,
            @Query("offset") int offset
    );
}

