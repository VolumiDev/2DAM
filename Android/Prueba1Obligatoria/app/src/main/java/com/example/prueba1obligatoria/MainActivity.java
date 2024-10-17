package com.example.prueba1obligatoria;

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

    TextView tv_presentacion;
    Button btn_comenzar;
    Spinner spn_nivel;
    List<String> niveles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //LLAMAMOS AL METODO QUE INCIA Y ESCUCHA A LOS CONTROLES
        asigancionElementos();

        //ASIGNAMOS LOS NIVELES DE jUEGO SPINER Y CRAMOS EL ADAPTADOR
        adaptadorSpiner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //ASIGNACION DE ELEMENTOS DE LA VISTA Y ESCUHADOR DEL BOTON Y CAMBIAMOS SU COLOR
    private void asigancionElementos(){
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


    //METODO ESCUCHADOR DE LOS ELEMENTOS
    @Override
    public void onClick(View view) {

    }
}