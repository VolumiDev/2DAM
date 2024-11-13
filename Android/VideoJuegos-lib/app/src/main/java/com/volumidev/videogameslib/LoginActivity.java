package com.volumidev.videogameslib;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText input_user, input_pass;
    Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //Inicializamos los elementos de la vista
        inputsSettings();
        //Asignamos los colores a los botones
        buttonsSettings();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Asiganmos los colores de los botones
     */
    private void buttonsSettings(){
        btn_login.setBackgroundColor(this.getResources().getColor(R.color.yellow_500));
        btn_register.setBackgroundColor(this.getResources().getColor(R.color.yellow_500));
    }

    /**
     * Capturamos los elementos de la vista
     */
    private void inputsSettings(){
        input_user = findViewById(R.id.editText_username);
        input_pass = findViewById(R.id.editText_password);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
    }
}