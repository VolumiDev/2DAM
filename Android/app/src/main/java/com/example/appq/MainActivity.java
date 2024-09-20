package com.example.appq;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_inicio;
    TextView tv_txt1;

    Button btn_del;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_inicio = findViewById(R.id.btn_inicio);
        tv_txt1= findViewById(R.id.tv_text1);
        btn_del = findViewById(R.id.btn_del);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_inicio.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_inicio:
                btn_inicio.setText("Texto del switch");
                Toast.makeText(this,"Cambio el texto", Toast.LENGTH_SHORT).show();
                Log.i("VolumiDev", "Cambio el texto");
                break;
            case R.id.btn_del:
                btn_del.setBackgroundColor(Color.RED);
                break;
            case R.id.btn_cancel:
                System.exit(0);
                break;
        }
    }
}
