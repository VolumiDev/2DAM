package com.volumidev.videogameslib;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Diego
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    private void showRegisterDialog(){
        //Objeto constructor de la ventana de dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("Registro de usuario");

        //Inflamos el layout del dialogo
        View dialogView = getLayoutInflater().inflate(R.layout.register_alert_dialog, null);
        builder.setView(dialogView);

        EditText register_et_usuario = dialogView.findViewById(R.id.register_editText_username);
        EditText register_et_pass = dialogView.findViewById(R.id.register_editText_password);

        Button register_btn_register = dialogView.findViewById(R.id.register_btn_register);
        Button register_btn_return = dialogView.findViewById(R.id.register_btn_return);
        register_btn_register.setOnClickListener(v -> {
            Usuario nuevoUsuario = new Usuario(register_et_usuario.getText().toString(), register_et_pass.getText().toString());
            nuevoUsuario.insertar(this);
        });
        register_btn_return.setOnClickListener(v -> {
            builder.create().dismiss();
        });

        /*
        builder.setPositiveButton("Registrarse", (dialog, which) -> {
            Usuario nuevoUsuario = new Usuario(register_et_usuario.getText().toString(), register_et_pass.getText().toString());
            nuevoUsuario.insertar(this);
        });

        builder.setNegativeButton("Volver", (dialog, which) -> {
            dialog.dismiss();
        });
*/
        builder.create().show();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                showRegisterDialog();
                break;
        }
    }
}