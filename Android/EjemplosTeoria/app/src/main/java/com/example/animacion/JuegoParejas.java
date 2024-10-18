package com.example.animacion;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JuegoParejas extends AppCompatActivity implements View.OnTouchListener{

    private ImageView iv_kiwi0, iv_kiwi1, iv_kiwi2, iv_platano0, iv_platano1,iv_platano2 , iv_manzana0, iv_manzana1, iv_manzana2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juego_parejas);

        iv_kiwi0=findViewById(R.id.iv_kiwi0);
        iv_kiwi1=findViewById(R.id.iv_kiwi1);
        iv_kiwi2=findViewById(R.id.iv_kiwi2);
        iv_manzana0=findViewById(R.id.iv_manzana0);
        iv_manzana1=findViewById(R.id.iv_manzana1);
        iv_manzana2=findViewById(R.id.iv_manzana2);
        iv_platano0 = findViewById(R.id.iv_platano0);
        iv_platano1 = findViewById(R.id.iv_platano1);
        iv_platano2 = findViewById(R.id.iv_platano2);

        iv_kiwi0.setOnTouchListener(this);
        iv_kiwi1.setOnTouchListener(this);
        iv_kiwi2.setOnTouchListener(this);
        iv_manzana0.setOnTouchListener(this);
        iv_manzana1.setOnTouchListener(this);
        iv_manzana2.setOnTouchListener(this);
        iv_platano0.setOnTouchListener(this);
        iv_platano1.setOnTouchListener(this);
        iv_platano2.setOnTouchListener(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }
}