package com.example.listaempleados;

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

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText et_user, et_pass;
    Button btn_recordar;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        btn_recordar = findViewById(R.id.btn_recordar);

        btn_recordar.setOnClickListener(this);

        preferencias = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        if(preferencias.contains("user")){
            et_user.setText(preferencias.getString("user", "no guardado"));
            et_pass.setText(preferencias.getString("pass", "no guardada"));
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_recordar:
                preferencias = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("user", et_user.getText().toString());
                editor.putString("pass", et_pass.getText().toString());
                editor.apply();
                break;
        }
    }
}