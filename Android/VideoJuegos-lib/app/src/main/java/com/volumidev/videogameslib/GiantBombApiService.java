package com.volumidev.videogameslib;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiantBombApiService {
    @GET("search/")
    Call<SearchResponse> searchGames(
            @Query("query") String query,
            @Query("api_key") String apiKey,
            @Query("format") String format,
            @Query("resources") String resources,
            @Query("field_list") String fieldList
    );
}
