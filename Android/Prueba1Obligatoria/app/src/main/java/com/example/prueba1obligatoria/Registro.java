package com.example.prueba1obligatoria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText et_user, et_pass;
    Button btn_registro;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_password);
        btn_registro = findViewById(R.id.btn_registro);
        btn_registro.setBackgroundColor(getResources().getColor(R.color.btnFondo));
        btn_registro.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_registro:
                registroAcction();
                break;
        }
    }

    private void registroAcction(){
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("usuario", et_user.getText().toString());
        editor.putString("contraseña", et_pass.getText().toString());
        editor.apply();

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}