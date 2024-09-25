package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Saludo extends AppCompatActivity {

    TextView tv_saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saludo);

        tv_saludo = findViewById(R.id.tv_saludo);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String user = getIntent().getStringExtra("user");
        String pass = getIntent().getStringExtra("pass");
        if(user.equalsIgnoreCase("Volumi") && pass.equalsIgnoreCase("1234")){
            tv_saludo.setText("Bienvenido " + user);
        }else{
            tv_saludo.setText("CONTRASEÑA INCORRECTA");
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
        }
    }
}