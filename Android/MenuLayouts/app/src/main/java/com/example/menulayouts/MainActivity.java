package com.example.menulayouts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_frame;
    Button btn_linear;
    Button btn_relative;
    Button btn_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_frame = findViewById(R.id.btn_frame);
        btn_linear = findViewById(R.id.btn_linear);
        btn_relative = findViewById(R.id.btn_relative);
        btn_table = findViewById(R.id.btn_table);


        btn_frame.setOnClickListener(this);
        btn_linear.setOnClickListener(this);
        btn_relative.setOnClickListener(this);
        btn_table.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        Log.i("Volumi", "Estamos dentro del boton");
        Intent intent;
        switch(v.getId()){
            case R.id.btn_frame:
                Log.i("Volumi", "Estamos dentro de FRAME");
                intent = new Intent(this, FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_linear:
                Log.i("Volumi", "Estamos dentro de LINEAR");
                intent = new Intent(this, LinearLayout.class);
                startActivity(intent);
                break;
            case R.id.btn_relative:
                Log.i("Volumi", "Estamos dentro de RELATIVE");
                intent = new Intent(this, RelativeLayout.class);
                startActivity(intent);
                break;
            case R.id.btn_table:
                Log.i("Volumi", "Estamos dentro de TABLE");
                intent = new Intent(this, TableLayout.class);
                startActivity(intent);
                break;
        }
    }
}