package com.volumidev.videogameslib;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Clase que representa el servicio de Giant Bomb.
 */
public class GiantBombService {
    private final GiantBombApi giantBombApi;
    private final String apiKey;
    private final String format;

    /**
     * Constructor del servicio.
     *
     * @param apiKey Tu clave de API de Giant Bomb.
     * @param format El formato de la respuesta (por ejemplo, "json").
     */
    public GiantBombService(String apiKey, String format) {
        this.giantBombApi = RetrofitClient.getClient().create(GiantBombApi.class);
        this.apiKey = apiKey;
        this.format = format;
    }


    /**
     * Método asíncrono para realizar una búsqueda de juegos por nombre.
     *
     * @param query El término de búsqueda (nombre del juego).
     * @param limit Número máximo de resultados por página.
     * @param offset Desplazamiento para paginación.
     * @param callback La callback para manejar la respuesta.
     */
    public void searchGamesAsync(String query, int limit, int offset, Callback<ApiResponse<Game>> callback) {
        Call<ApiResponse<Game>> call = giantBombApi.searchGames(query, "game", apiKey, format, limit, offset);
        call.enqueue(callback);
    }
}
