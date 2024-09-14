package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_editable = findViewById(R.id.et_editableText);
        TextView tv_text = findViewById(R.id.tv_text);
        Button btn_pulsame = findViewById(R.id.btn_pulsame);
        btn_pulsame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_text.setText("Hola Diego");
            }
        });
    }
}