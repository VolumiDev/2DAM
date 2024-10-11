package com.example.listaempleados;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
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

public class ListEmployees extends AppCompatActivity implements View.OnClickListener{

    TextView tv_employee;
    Button btn_return, btn_login;
    Employee emp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        btn_return = findViewById(R.id.btn_return);
        tv_employee = findViewById(R.id.tv_employee);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_return.setOnClickListener(this);

        /*
        //creando el array desde resourcer, en el XML
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.animales, android.R.layout.simple_spinner_item);

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data);
        adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, valuesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter2);
        */
        emp =(Employee) getIntent().getSerializableExtra("empleado");
        tv_employee.setText(emp.show());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Log.i("Volumi", "dentro de boton");
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
        }
    }
}