package com.example.ejemsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View

        .OnClickListener{

    private Button btn_registrar, btn_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_registrar = findViewById(R.id.btn_registro);
        btn_mostrar = findViewById(R.id.btn_mostrar);

        btn_mostrar.setOnClickListener(this);
        btn_registrar.setOnClickListener(this);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_mostrar:
                Intent i = new Intent(this, MostrarUsuarios.class);
                startActivity(i);
                break;
            case R.id.btn_registro:
                Intent i1 = new Intent(this, Registrar.class);
                startActivity(i1);
                break;
        }
    }
}