package com.volumidev.videogameslib;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class InitialSplas extends AppCompatActivity {

    private ImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_initial_splas);

        /**
         * Inicializamos la vista del gif
         */
        gifImageView = findViewById(R.id.id_loadingGif);

        Glide.with(this)
                .asGif()
                .load(R.drawable.loadinggif)
                .into(gifImageView);

        /**
         * Asignamos un temporizador antes de pasar a la siguiente pantalla
         */
        TimerTask splash = new TimerTask() {
            @Override
            public void run() {
                Intent  intent = new Intent(InitialSplas.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(splash, 6000);






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}