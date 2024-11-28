package com.volumidev.videogameslib;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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

    EditText login_input_user, login_input_pass;
    Button btn_login, btn_register;
    CheckBox login_recordarUser;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //Inicializamos los elementos de la vista
        inputsSettings();
        //Asignamos los colores a los botones
        buttonsSettings();
        //Precargamos la info del SharedPreferences si tiene la opcion.
        precargamosInput();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Asiganmos los colores de los botones
     */
    private void buttonsSettings() {
        btn_login.setBackgroundColor(this.getResources().getColor(R.color.green_500));
        btn_register.setBackgroundColor(this.getResources().getColor(R.color.yellow_500));
    }

    /**
     * Capturamos los elementos de la vista
     */
    private void inputsSettings() {
        login_input_user = findViewById(R.id.editText_username);
        login_input_pass = findViewById(R.id.editText_password);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        login_recordarUser = findViewById(R.id.checkbox_recordarUsuario);
    }

    /**
     * MOSTRAMOS EL ALERTDIALOG SOBRE EL QUE NOS VAMOS A REGISTRAR
     */
    private void showRegisterDialog() {
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
        register_btn_register.setBackgroundColor(this.getResources().getColor(R.color.green_500));
        register_btn_return.setBackgroundColor(this.getResources().getColor(R.color.yellow_500));


        // CREAR Y MOSTRAR EL ALERTDIALOG
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //CONFIGURAMOS LOS DOS BONOTES
        register_btn_register.setOnClickListener(v -> {
            if (register_et_usuario.getText().toString().trim().isEmpty() || register_et_pass.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Usuario nuevoUsuario = new Usuario(register_et_usuario.getText().toString(), register_et_pass.getText().toString());
                nuevoUsuario.insertar(this);
                alertDialog.dismiss();
            }
        });

        register_btn_return.setOnClickListener(v -> {
            alertDialog.dismiss();
        });
    }

    /**
     * Realizamos la autenticacion del usuario.
     */
    private void userAutentication() {
        Usuario user = new Usuario();

        String username = login_input_user.getText().toString();
        String password = login_input_pass.getText().toString();

        String sql = "SELECT * FROM usuarios WHERE nombre LIKE '" + username + "'";
        user.getUsuarioFromDB(this, sql);

        if (user.getNombre() != null && user.getPass() != null) {
            String hashingPass = user.encriptarPass(password);

            if (user.getNombre() != null && user.getPass().equals(hashingPass)) {
                validamosRecordarUsuario();
                //vamos a la pantalla de pefil
                //Intent i = new Intent(this, Profile_Activity.class);
                Intent i = new Intent(this, GameShearchActivity.class);
                i.putExtra("user", user.getNombre());
                startActivity(i);
            }
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * Comprobamos el estado del chek para ver si tenemos que almacenar los datos de usuario en el SharedPreferences
     */
    private void validamosRecordarUsuario() {
        //Inicializamos el sharePreferences
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferencias.edit();
        if (login_recordarUser.isChecked()) {
            editor.putString("usuario", login_input_user.getText().toString());
            editor.putString("contraseña", login_input_pass.getText().toString());
            editor.putBoolean("recordar", true);
        } else {
            editor.putBoolean("recordar", false);
        }
        //aplicamos cambios
        editor.apply();
    }

    /**
     * Precargamos los input con los valores si tiene opcion de recordar
     */
    private void precargamosInput() {
        //Inicializamos el sharePreferences
        preferencias = getSharedPreferences("preferencias", MODE_PRIVATE);
        if (preferencias.getBoolean("recordar", false)) {
            login_input_user.setText(preferencias.getString("usuario", "no existe"));
            login_input_pass.setText(preferencias.getString("contraseña", "no existe"));
            login_recordarUser.setSelected(true);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                userAutentication();
                break;
            case R.id.btn_register:
                showRegisterDialog();
                break;
        }
    }
}