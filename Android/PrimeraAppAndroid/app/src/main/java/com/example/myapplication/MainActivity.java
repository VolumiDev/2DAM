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
        Button btn_pulsame = findViewById(R.id.btn_pulsame);
        //pulsaBtn(btn_pulsame, et_editable);

        btn_pulsame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pulsame.setText(et_editable.getText());
            }
        });


    }
//    public void pulsaBtn(Button btn_pulsame, EditText et_editable){
//        btn_pulsame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btn_pulsame.setText(et_editable.getText());
//            }
//        });
//    }
}