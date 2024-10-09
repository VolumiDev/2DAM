package com.example.listaempleados;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et_name, et_company, et_position;
    ImageView imgV_photo;
    Button btn_add, btn_show;
    Spinner spin_employees;

    ArrayList<Employee> employees = new ArrayList<Employee>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_company = findViewById(R.id.et_company);
        et_position = findViewById(R.id.et_position);
        imgV_photo = findViewById(R.id.iv_user);
        spin_employees = findViewById(R.id.spn_Employees);

        btn_add = findViewById(R.id.btn_add);
        btn_show = findViewById(R.id.btn_show);

        btn_add.setOnClickListener(this);
        btn_show.setOnClickListener(this);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        String name, company, position;
        name = et_name.getText().toString();
        company = et_company.getText().toString();
        position = et_position.getText().toString();

        Employee e = new Employee(name, company, position);

        switch(v.getId()){
            case R.id.btn_add:
                employees.add(e);
                et_name.setText("");
                et_position.setText("");
                et_company.setText("");
                imgV_photo.setImageResource(R.drawable.marineb);

                ArrayAdapter<Employee> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, employees);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin_employees.setAdapter(adapter);

                Log.i("volumi", "pulsa");
                for (Employee emp :
                        employees) {
                    Log.i("Volumi", emp.show());
                }
                break;

            case R.id.btn_show:
                Intent intent = new Intent(this, ListEmployees.class);
                intent.putExtra("employeesList", employees);
                Log.i("Volumi", "pulsado");
                startActivity(intent);

                break;
        }
    }
}