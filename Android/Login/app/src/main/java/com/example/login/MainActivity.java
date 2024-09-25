package com.example.login;

import android.content.Intent;
import android.os.Bundle;
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

    TextView tv_user;
    TextView tv_pass;
    EditText et_user;
    EditText et_pass;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv_user = findViewById(R.id.tv_user);
        tv_pass = findViewById(R.id.tv_pswrd);
        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);

        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Saludo.class);

        intent.putExtra("user", et_user.getText().toString());
        intent.putExtra("pass", et_pass.getText().toString());

        Log.i("volumi", et_user.getText().toString());
        startActivity(intent);
    }
}