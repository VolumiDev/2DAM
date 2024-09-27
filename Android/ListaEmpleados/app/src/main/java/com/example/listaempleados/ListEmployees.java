package com.example.listaempleados;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListEmployees extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner, spinner1;
    Button btn_return;
    ArrayAdapter adapter, adapter2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        btn_return = findViewById(R.id.btn_return);

        List<String> valuesList = List.of("Value1", "Value2", "Value3");

        ArrayList<Employee> employeesList= getIntent().getParcelableArrayListExtra("employees");
        ArrayList<String> data = new ArrayList<String>();
        for (Employee emp : employeesList) {
            data.add(emp.show());
        }
        spinner = findViewById(R.id.spn_lista);
        spinner1 = findViewById(R.id.spn_lista1);

        //creando el array desde resourcer, en el XML
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.animales, android.R.layout.simple_spinner_item);

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data);
        adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, valuesList);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

    }
}