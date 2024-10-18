package com.example.prueba1obligatoria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.function.Predicate;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText[] et_txt;
    Button[] btns;
    CheckBox cb_recordar;
    SharedPreferences preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        et_txt = new EditText[2];
        btns = new Button[2];
        cb_recordar = findViewById(R.id.cb_recordar);
        et_txt[0] = findViewById(R.id.et_user);
        et_txt[1] = findViewById(R.id.et_password);
        btns[0] = findViewById(R.id.btn_registro);
        btns[1] = findViewById(R.id.btn_login);
        Log.i("volumi", "esta");
        estaRecordado();
        setBtns();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case (R.id.btn_registro):
                registroAcction();
                break;
            case (R.id.btn_login):
                loginAcction();
                break;
        }
    }

    //SETEAMOS LOS BOTOS CON LAS PROPIEDADES QUE QUEREMOS LOS HACEMOS ESCUCHADORES
    private void setBtns(){
        for (int i = 0; i < btns.length; i++){
            btns[i].setOnClickListener(this);
            btns[i].setBackgroundColor(this.getResources().getColor(R.color.btnFondo));
        }
    }

    // METODO QUE EJECUTAMOS EN EL BOTON REGISTRO
    private void registroAcction(){
        Intent intentRegistro = new Intent(this, Registro.class);
        startActivity(intentRegistro);
    }

    //METODO QUE EJECUTAMOS EN EL BOTON DE LOGIN
    private void loginAcction(){
        if(cb_recordar.isChecked()){
            preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
            SharedPreferences.Editor editor =preferencias.edit();
            editor.putInt("recordar", 1);
            editor.apply();
        }else {
            SharedPreferences.Editor editor =preferencias.edit();
            editor.putInt("recordar", 0);
            editor.apply();
        }
        autenticacion();
    }

    //VALIDAMOS QUE NOS INGRESE EL USUARIO Y PASS QUE ESTAN EN SHARED PREF
    private void autenticacion(){
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
        if(preferencias.getString("usuario","no guardado").equalsIgnoreCase(et_txt[0].getText().toString())
        && preferencias.getString("contraseña","no guardado").equalsIgnoreCase(et_txt[1].getText().toString())){
            Intent intenMain = new Intent(this, MainActivity.class);
            intenMain.putExtra("usuario",et_txt[0].getText().toString());
            startActivity(intenMain);
        }else {
            Log.i("Volumi","entra en el else");
            Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
        }
    }

    //METODO QUE NOS MUESTRA EL USUARIO Y PASS ALMACENADOS EN SHARED PREF SI ELIGIO RECORAR
    private void estaRecordado(){
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
        if(preferencias.contains("usuario") && preferencias.contains("contraseña") ){
            if(preferencias.contains("recordar")){
                int recordar = preferencias.getInt("recordar", -1);
                if(recordar == 1){
                    et_txt[0].setText(preferencias.getString("usuario","no guardado"));
                    et_txt[1].setText(preferencias.getString("contraseña","no guardado"));
                }
            }
        }
    }
}