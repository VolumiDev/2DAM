package com.volumidev.videogameslib;

import android.content.Intent;
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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Clase que representa la Activity de búsqueda de juegos.
 */
public class GameSearchActivity extends AppCompatActivity implements View.OnClickListener {
    final String API_KEY = "53ee008e07ec26168a0585add2642001c68eb575";
    final String FORMAT = "json";

    private GiantBombApi giantBombApi;
    private GameRecyclerAdapter gamesAdapter;
    private EditText etGameName;
    private RecyclerView rvGames;
    private Button btnProfile, btnShearch;
    private Usuario user;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_shearch);

        //RECOGEMOS LOS DATOS QUE NOS MANDAMOS DESDE EL INTENT GENERADOR
        intent = getIntent();
        user = (Usuario) intent.getSerializableExtra("user");


        //INICIALIZAMOS LA VISTAS
        initViews();


        //CONFIGURAMOS EL ADAPTER
        RecyclerView rvGames = findViewById(R.id.recyclerViewGames);
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        gamesAdapter = new GameRecyclerAdapter(new ArrayList<Game>(), this);
        rvGames.setAdapter(gamesAdapter);

        //CONFIGURAMOS EL SWIPE CONTROLLER
        GameSearchSwipeController swipeController = new GameSearchSwipeController(gamesAdapter, user);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(rvGames);


        //INICIAMOS EL RETROFIT Y LA INTERFAZ DE LA API
        giantBombApi = RetrofitClient.getClient().create(GiantBombApi.class);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Inicializamos las vistas de la Activity
     */
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

    /**
     * Manejador de clics para los botones.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonProfile:
                    Intent i = new Intent(this, Profile_Activity.class);
                    i.putExtra("user", user);
                    startActivity(i);
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

    /**
     * Realiza una búsqueda en la API de Giant Bomb.
     * @param query
     * @param resources
     * @param apiKey
     * @param format
     * @param limit
     * @param offset
     */
    private void realizarBusqueda(String query, String resources, String apiKey, String format, int limit, int offset) {
        // Ocultar el mensaje de "No Hay Resultados" antes de iniciar la búsqueda

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

                    //CREAMOS LA LISTA DE LOS JUEGOS CON LOS ELEMENTOS QUE RECOJEMOS EN EL JSON DE LA API
                    List<Game> searchResults = response.body().getResults();
                    Log.d("GiantBombSearch", "Número de resultados: " + (searchResults != null ? searchResults.size() : "null"));

                    //ASIGNAMOS LA LISTA DE JUEGOS AL ADAPTER
                    if (searchResults != null && !searchResults.isEmpty()) {
                        // Actualiza el adaptador con los nuevos datos
                        gamesAdapter.setGamesList(searchResults);
                    } else {
                        gamesAdapter.setGamesList(new ArrayList<>()); // Pasar una lista vacía
                    }
                } else {
                    Log.e("GiantBombSearch", "Error en la respuesta: " + response.code() + " - " + response.message());
                    Toast.makeText(GameSearchActivity.this, "Error en la búsqueda: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ApiResponse<Game>> call, Throwable t) {
                Log.e("GiantBombSearch", "Fallo en la petición: " + t.getMessage());
                Toast.makeText(GameSearchActivity.this, "Fallo en la petición: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}