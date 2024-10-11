package com.example.listaempleados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MiAdaptador extends ArrayAdapter<Employee> {

    private Context context;
    private List<Employee> employees;

    public MiAdaptador(Context context, ArrayList<Employee> employees){
        super(context, 0, employees);
        this.context = context;
        this.employees = employees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        // Inflate the custom layout if necessary
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false);
        }
        // Get the current object from the list
        Employee employee = getItem(position);

        // Get the TextView from the custom layout
        TextView textView = convertView.findViewById(R.id.spinner_item);

        // Set the text for the current item (customize this as needed)
        if (employee != null) {
            textView.setText(employee.getName());
        }

        return convertView;

    }


}
