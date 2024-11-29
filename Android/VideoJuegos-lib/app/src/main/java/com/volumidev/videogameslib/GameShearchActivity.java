package com.volumidev.videogameslib;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameShearchActivity extends AppCompatActivity implements View.OnClickListener {
    final String API_KEY = "53ee008e07ec26168a0585add2642001c68eb575";
    final String FORMAT = "json";

    private GiantBombApi giantBombApi;
    private GameRecyclerAdapter gamesAdapter;
    private EditText etGameName;
    private TextView textViewNoResults;
    private RecyclerView rvGames;
    private Button btnProfile, btnShearch;
    private List<Game> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_shearch);

        //INICIALIZAMOS LA VISTAS
        initViews();
        textViewNoResults = findViewById(R.id.textViewNoResults);


        //CONFIGURAMOS EL ADAPTER
        RecyclerView rvGames = findViewById(R.id.recyclerViewGames);
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        gamesAdapter = new GameRecyclerAdapter(new ArrayList<Game>(), this);
        rvGames.setAdapter(gamesAdapter);

        //INICIAMOS EL RETROFIT Y LA INTERFAZ DE LA API
        giantBombApi = RetrofitClient.getClient().create(GiantBombApi.class);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initViews(){
        etGameName = findViewById(R.id.editTextSearch);
        rvGames = findViewById(R.id.recyclerViewGames);
        btnProfile = findViewById(R.id.buttonProfile);
        btnProfile.setBackgroundColor(getResources().getColor(R.color.yellow_500));
        btnProfile.setOnClickListener(this);
        btnShearch = findViewById(R.id.buttonSearch );
        btnShearch.setBackgroundColor(getResources().getColor(R.color.yellow_500));
        btnShearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonProfile:

                break;
            case R.id.buttonSearch:
                    String query = etGameName.getText().toString().trim();
                    if(!TextUtils.isEmpty(query)){
                        realizarBusqueda(query, "game", API_KEY, FORMAT, 10, 0);
                    }else{
                        Toast.makeText(this, "Por favor, ingresa un nombre de juego", Toast.LENGTH_SHORT).show();

                    }
                    break;
        }
    }


    private void realizarBusqueda(String query, String resources, String apiKey, String format, int limit, int offset) {
        // Ocultar el mensaje de "No Hay Resultados" antes de iniciar la búsqueda
        textViewNoResults.setVisibility(View.GONE);

        Call<ApiResponse<Game>> call = giantBombApi.searchGames(query, resources, apiKey, format, limit, offset);
        call.enqueue(new Callback<ApiResponse<Game>>() {
            @Override
            public void onResponse(Call<ApiResponse<Game>> call, Response<ApiResponse<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Log para depuración
                    try {
                        String jsonResponse = new Gson().toJson(response.body());
                        Log.d("GiantBombSearch", "Respuesta JSON: " + jsonResponse);
                    } catch (Exception e) {
                        Log.e("GiantBombSearch", "Error al convertir la respuesta a JSON", e);
                    }

                    List<Game> searchResults = response.body().getResults();
                    Log.d("GiantBombSearch", "Número de resultados: " + (searchResults != null ? searchResults.size() : "null"));

                    if (searchResults != null && !searchResults.isEmpty()) {
                        // Actualiza el adaptador con los nuevos datos
                        gamesAdapter.setGamesList(searchResults);
                        // Ocultar el mensaje de "No Hay Resultados"
                        textViewNoResults.setVisibility(View.GONE);
                    } else {
                        // Mostrar el mensaje de "No Hay Resultados"
                        textViewNoResults.setVisibility(View.VISIBLE);
                        gamesAdapter.setGamesList(new ArrayList<>()); // Pasar una lista vacía
                    }
                } else {
                    Log.e("GiantBombSearch", "Error en la respuesta: " + response.code() + " - " + response.message());
                    Toast.makeText(GameShearchActivity.this, "Error en la búsqueda: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ApiResponse<Game>> call, Throwable t) {
                Log.e("GiantBombSearch", "Fallo en la petición: " + t.getMessage());
                Toast.makeText(GameShearchActivity.this, "Fallo en la petición: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}