package com.example.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //OBTENER SHARED PREFERENCES
        SharedPreferences sharePref = getSharedPreferences("misPreferencias", MODE_PRIVATE);
        //CREAMOS ELEDITOR DEL SHARED PREFERENCEES PARA PODER EDITARLO
        SharedPreferences.Editor editor = sharePref.edit();

        //GUARDAMOS DATOS
        editor.putString("nombreUsuario", "Juan");
        editor.putInt("edad", 34);
        editor.putBoolean("esPrimeraVez", true);
        //VUELCA EL CONTENIDO DEL FICHERO EN MEMORIA
        editor.apply();

        //PARA LA LECTURA DE DATOS
        String nombreUser = sharePref.getString("nombreUsuario", "No disponible");
        int edad = sharePref.getInt("edad", 0);
        boolean primeraVez = sharePref.getBoolean("esPrimeraVez", false);

        Log.d("Volumi", nombreUser);
        Log.d("Volumi", ""+edad);
        Log.d("Volumi", ""+primeraVez);

        //PARA ELIMINAR UNA DE LAS ETIQUETAS
        Log.d("Volumi", "Eliminamos la edad");

        editor.remove("edad");
        editor.apply();
        //MOSTRAMOS DE NUEVO LA EDAD
        edad = sharePref.getInt("edad", -1);
        Log.d("Volumi", ""+edad);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}