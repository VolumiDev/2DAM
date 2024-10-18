package com.example.prueba1obligatoria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity implements View.OnClickListener {
    TextView tv_marcador, tv_pregunta;
    ImageView iv_imagen;
    Button[] btns_respuestas;
    BDPreguntas preguntas;
    int np, nivel, puntuacion;
    MediaPlayer mp;
    SharedPreferences preferencias;
    boolean play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juego);

        //ASIGNAMOS LOS ELEMENTOS DE LA VISTA Y LOS ESCUCHAMOS
        np=0;
        play=false;
        puntuacion=0;
        tv_marcador=findViewById(R.id.tv_marcador);
        tv_marcador.setText(String.valueOf(puntuacion)+" puntos");
        tv_pregunta=findViewById(R.id.tv_pregunta);
        iv_imagen=findViewById(R.id.iv_imagen);
        btns_respuestas=new Button[4];
        btns_respuestas[0]=findViewById(R.id.btn_resp1);
        btns_respuestas[1]=findViewById(R.id.btn_resp2);
        btns_respuestas[2]=findViewById(R.id.btn_resp3);
        btns_respuestas[3]=findViewById(R.id.btn_resp4);

        Log.i("volumi", ""+btns_respuestas.length);

        for(int i=0;i<btns_respuestas.length;i++){
            btns_respuestas[i].setOnClickListener(this);
            btns_respuestas[i].setBackgroundColor(this.getResources().getColor(R.color.btnFondo));
        }

        //GENERAMOS LAS PREGUNTAS Y LAS RESPUESTAS
        generarPreguntas();
        //RELLENAMOS LA PREGUNTA LA IMAGEN Y LA RESPUESTA
        rellenarDatos();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    //GENERAMOS LAS PREGUNTAS Y LAS RESPUESTAS SEGUN EL NIVEL SELECCIONADO

    private void generarPreguntas(){
        nivel=getIntent().getIntExtra("nivel",0);
        preguntas = new BDPreguntas(nivel);
    }
    // RELLENAMOS LA PREGUNTA LA IMAGEN Y LA RESPUESTA
    private void rellenarDatos(){
        tv_pregunta.setText(preguntas.getPreguntas()[np]);
        rellenarPregunta();
        rndResp();
    }
    //RELLENAMOS PREGUNTA Y IMAGEN DEPENDIENDO DE EL TIPO DE PREGUNTA QUE SEA AÑADE UN BOTON DE PLAY PARA EL SONIDO TAMBIEN EN
    //FUNCION DEL NIVEL EN EL QUE ESTEMOS METE UNO U OTRO RECURSO
    private void rellenarPregunta(){
        tv_pregunta.setText(preguntas.getPreguntas()[np]);
        switch(nivel){
            //NIVEL FACIL
            case 0:
                switch (np){
                    case 0:
                        iv_imagen.setImageResource(R.drawable.f0);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);
                        break;

                    case 1:
                        iv_imagen.setImageResource(R.drawable.reproductor);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);
                        iv_imagen.setOnClickListener(this);

                        break;

                    case 2:
                        iv_imagen.setImageResource(R.drawable.f2);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;

                    case 3:
                        iv_imagen.setImageResource(R.drawable.reproductor);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);
                        //sonido
                        iv_imagen.setOnClickListener(this);


                        break;

                    case 4:
                        iv_imagen.setImageResource(R.drawable.f4);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;
                }
                break;
            //NIVEL MEDIO
            case 1:
                switch (np){
                    case 0:
                        iv_imagen.setImageResource(R.drawable.m0);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;

                    case 1:
                        iv_imagen.setImageResource(R.drawable.reproductor);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        //sonido
                        iv_imagen.setOnClickListener(this);

                        break;

                    case 2:
                        iv_imagen.setImageResource(R.drawable.m2);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;

                    case 3:
                        iv_imagen.setImageResource(R.drawable.reproductor);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        //sonido
                        iv_imagen.setOnClickListener(this);

                        break;

                    case 4:
                        iv_imagen.setImageResource(R.drawable.m4);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;
                }
                break;
            //NIVEL DIFICIL
            case 2:
                switch (np){
                    case 0:
                        iv_imagen.setImageResource(R.drawable.d0);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;

                    case 1:
                        iv_imagen.setImageResource(R.drawable.reproductor);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        //sonido
                        iv_imagen.setOnClickListener(this);

                        break;

                    case 2:
                        iv_imagen.setImageResource(R.drawable.d2);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;

                    case 3:
                        iv_imagen.setImageResource(R.drawable.reproductor);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        //sonido
                        iv_imagen.setOnClickListener(this);

                        break;

                    case 4:
                        iv_imagen.setImageResource(R.drawable.d4);
                        tv_pregunta.setText(preguntas.getPreguntas()[np]);

                        break;
                }
                break;
        }
    }
//GENERAMOS LAS RESPUESTAS ALEATORIAS Y LAS AIGNAMOS A LOS BOTONES CORRESPONDIENTES
    private void rndResp(){
        Random rnd = new Random();
        ArrayList<String> posiblesRespuestas = new ArrayList<>();
        for (int i = 0; i < btns_respuestas.length; i++) {
            posiblesRespuestas.add(preguntas.getRespuestas()[np].split("-")[i]);
            //Log.i("test", ""+posiblesRespuestas.get(i));
        }
        for (int i = 0; i < btns_respuestas.length; i++) {
            int index = rnd.nextInt(posiblesRespuestas.size());
            //Log.i("test", ""+index);
            btns_respuestas[i].setText(posiblesRespuestas.get(index));
            posiblesRespuestas.remove(index);
        }
    }


// VALIDAMOS QUE LA RESPUESTA SEA LA CORRECTA Y LE INCREMENTAMOS LA PUNTUACION
    private void validarRespuesta(String respuesta){

        Log.i("test", "respuesta "+respuesta);
        Log.i("test", "correcta "+preguntas.getRespuestas()[0]);
        if(respuesta.equalsIgnoreCase(preguntas.getRespuestas()[np].split("-")[0])){
            //acierto
            puntuacion+=10;
            Log.i("test", "acierto "+puntuacion);
            tv_marcador.setText(""+puntuacion+" puntos");
            resetearActivity();
        }else{
            //fallo
            Log.i("test", "fallo "+puntuacion);
            resetearActivity();
        }
    }


//VALIDAMOS EN QUE PUNTO ESTAMOS Y RESETEAMOS LA ACTIVITY CON LOS NUEVOS DATOS

    private void resetearActivity(){
        np++;
        if(np==5){
            guardarPuntuacion();
            selecciondeNivel();
        }else{
            rellenarDatos();
        }
    }

//GUARDAMOS LA MEJOR PUNTUACION SI ES SUPERIOR A LA QUE TENIAMOS
    private void guardarPuntuacion(){
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
        Log.i("test pref", "puntuacion "+puntuacion);
        if(!preferencias.contains("mejorPuntuacion")){
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putInt("mejorPuntuacion", puntuacion);
            editor.apply();
        }else{
            if(puntuacion>preferencias.getInt("mejorPuntuacion",0)){
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putInt("mejorPuntuacion", puntuacion);
                editor.apply();
            }
        }
    }
//NOS LLEVA DE NUEVO A LA ACTIVITY DE ELEGIR NIVEL
    private void selecciondeNivel(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.iv_imagen):
                    switch (nivel){
                        case 0:
                            switch (np){
                                case 1:
                                    if(!play){
                                        play=true;
                                        mp = MediaPlayer.create(this, R.raw.f1);
                                        mp.start();
                                    }else{
                                        mp.pause();
                                        play=false;
                                    }


                                    break;
                                case 3:
                                    if(!play){
                                        play=true;
                                        mp = MediaPlayer.create(this, R.raw.f3);
                                        mp.start();
                                    }else{
                                        mp.pause();
                                        play=false;
                                    }

                                    break;
                            }
                            break;
                            case 1:
                                switch (np){
                                    case 1:
                                        if(!play){
                                            play=true;
                                            mp = MediaPlayer.create(this, R.raw.m1);
                                            mp.start();
                                        }else{
                                            mp.pause();
                                            play=false;
                                        }

                                        break;
                                    case 3:
                                        if(!play){
                                            play=true;
                                            mp = MediaPlayer.create(this, R.raw.m3);
                                            mp.start();
                                        }else{
                                            mp.pause();
                                            play=false;
                                        }

                                        break;
                                }
                                break;
                        case 2:
                            switch (np){
                                case 1:
                                    if(!play){
                                        play=true;
                                        mp = MediaPlayer.create(this, R.raw.d1);
                                        mp.start();
                                    }else{
                                        mp.pause();
                                        play=false;
                                    }

                                    break;
                                case 3:
                                    if(!play){
                                        play=true;
                                        mp = MediaPlayer.create(this, R.raw.d3);
                                        mp.start();
                                    }else{
                                        mp.pause();
                                        play=false;
                                    }

                                    break;
                            }
                            break;

                    }
                break;
            case (R.id.btn_resp1):
                validarRespuesta(btns_respuestas[0].getText().toString());
                break;
            case (R.id.btn_resp2):
                validarRespuesta(btns_respuestas[1].getText().toString());
                break;
            case (R.id.btn_resp3):
                validarRespuesta(btns_respuestas[2].getText().toString());

                break;
            case (R.id.btn_resp4):
                validarRespuesta(btns_respuestas[3].getText().toString());

                break;
        }
    }
}