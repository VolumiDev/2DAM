package com.example.prueba1obligatoria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_presentacion, tv_puntuacion;
    Button btn_comenzar;
    Spinner spn_nivel;
    List<String> niveles;
    SharedPreferences preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //LLAMAMOS AL METODO QUE INCIA Y ESCUCHA A LOS CONTROLES
        asigancionElementos();

        //ASIGNAMOS LOS NIVELES DE jUEGO SPINER Y CRAMOS EL ADAPTADOR
        adaptadorSpiner();

        //MODIFICAMOS EL TEXTVIEW DE BIENVENIDA PARA QUE MUESTRE EL NOMBRE DEL USUARIO
        saludo();
        //SETEAMOS LA MEJOR PUNTUACION
        mejorPuntuacion();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //ASIGNACION DE ELEMENTOS DE LA VISTA Y ESCUHADOR DEL BOTON Y CAMBIAMOS SU COLOR
    private void asigancionElementos(){
        tv_puntuacion=findViewById(R.id.tv_puntuacion);
        tv_presentacion=findViewById(R.id.tv_presentacion);
        btn_comenzar=findViewById(R.id.btn_comenzar);
        spn_nivel=findViewById(R.id.spn_nivel);
        btn_comenzar.setOnClickListener(this);
        btn_comenzar.setBackgroundColor(this.getResources().getColor(R.color.btnFondo));
    }

    //CREAMOS LA LISTA DE ELEMENTO SPINNER CON LOS NIVELES QUE TENDRÁ NUESTRO JUEGO.
    private List<String> listaNiveles(){
        List<String> list = new ArrayList<>();
        list.add("Facil");
        list.add("Medio");
        list.add("Dificil");
        return list;
    }

    //CREAMOS EL ADAPTADOR PARA EL SPINNER Y LA LISTA DE NIVELES
    private void adaptadorSpiner(){
        niveles = listaNiveles();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, niveles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_nivel.setAdapter(adapter);
    }

    //SALUDAMOS AL USUARIO QUE SE HA REGISTRADO
    private void saludo(){
        preferencias=getSharedPreferences("preferencias", MODE_PRIVATE);
        tv_presentacion.setText("Bienvenido "+preferencias.getString("usuario","no logado")+ ". Elija el nivel de su aventura:");
    }

    //METODO QUE CON EL QUE HACEMOS EL INTENT Y LE PASAMOS EL NIVEL SELECCIONADO
    private void comenzarJuego(){
        Intent intentJuego = new Intent(this, Juego.class);
        intentJuego.putExtra("nivel",spn_nivel.getSelectedItem().toString());
        startActivity(intentJuego);
    }

    //RECOGEMOLA MEJOR PUNTUACION DE SHARE PREF
    private void mejorPuntuacion(){
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
        if(preferencias.contains("mejorPuntuacion")){
            tv_puntuacion.setText("Mejor Puntuacion: "+ preferencias.getInt("mejorPuntuacion",0) +" puntos");
        }else{
            tv_puntuacion.setText("No hay puntuacion");
        }

    }


    //METODO ESCUCHADOR DE LOS ELEMENTOS
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_comenzar){
            Intent comenzarJuego = new Intent(this, Juego.class);
            comenzarJuego.putExtra("nivel",spn_nivel.getSelectedItemPosition());
            startActivity(comenzarJuego);
        }
    }
}