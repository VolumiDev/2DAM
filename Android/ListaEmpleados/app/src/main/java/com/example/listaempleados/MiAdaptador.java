package com.example.listaempleados;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MiAdaptador extends ArrayAdapter<Employee> {
    public MiAdaptador(Context context, ArrayList<Employee> employee){
        super(context, 0, employee);
    }
}
