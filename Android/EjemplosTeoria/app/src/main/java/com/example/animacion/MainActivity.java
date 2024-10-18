package com.example.animacion;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView ventanaImagen;
    //INSTANCIAMOS UN OBJETO DE ANIMATION DRAWABLE
    AnimationDrawable dAnimacion;
    Button btn_arrancar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /*
        * PRIMERO CREAMOS DENTRO DE DRAWABLE UN XML TIPO ANIMATIO
        * EN LA ETIQUETA LE TENEMOS QUE APLICAR ONESHOT = TRUE
        * METEMOS LOS ITEMS QUE QUEREMOS QUE CAMBIEN EN LA IMAGEN
        * */
        btn_arrancar = findViewById(R.id.btn_arrancar);
        btn_arrancar.setOnClickListener(this);
        ventanaImagen = findViewById(R.id.iv_animation);
        //DECIMOS QUE LA IV TENGA DE FONDO LA IMAGEN
        ventanaImagen.setBackgroundResource(R.drawable.animaciones);
        // PARA QUE SE VEA LE PONEMOS LA VISIBILIDADA VISIBLE
        ventanaImagen.setVisibility(View.VISIBLE);

        //
        dAnimacion = (AnimationDrawable) ventanaImagen.getBackground();
        dAnimacion.setOneShot(false);
        ventanaImagen.setVisibility(View.VISIBLE);
        dAnimacion.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(MainActivity.this, EjemploOnTouch.class);
                startActivity(intent);
            }
        }, 3000);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_arrancar:
                dAnimacion.start();
                break;
        }
    }
}