package com.example.reto1;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSuma;
    Button btnSalir;
    EditText etn1;
    EditText etn2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSalir = findViewById(R.id.btnSalir);
        btnSuma = findViewById((R.id.btnSuma));
        result = findViewById(R.id.tv_result);
        etn1 = findViewById(R.id.et_n1);
        etn2 = findViewById(R.id.et_n2);

        btnSuma.setOnClickListener(this);
        btnSalir.setOnClickListener(this);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static int suma(int n1, int n2){
        return (n1+n2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnSalir:
                System.exit(0);
                Log.i("VolumiDev", "Salir");
                break;
            case  R.id.btnSuma:
                result.setText(String.valueOf(suma(Integer.parseInt(etn1.getText().toString()), Integer.parseInt(etn2.getText().toString()))));
                //result.setText("hola");
                Log.i("VolumiDev", "suma");
        }
    }
}