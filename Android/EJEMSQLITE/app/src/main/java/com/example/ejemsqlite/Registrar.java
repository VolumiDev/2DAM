package com.example.ejemsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrar extends AppCompatActivity{

    private EditText et_nombre, et_telefono;
    private Button btn_registrar;
    private ConexionSQLite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        et_nombre = findViewById(R.id.et_nombre);
        et_telefono = findViewById(R.id.et_telefono);
        btn_registrar = findViewById(R.id.btn_registrar);
        btn_registrar.setOnClickListener(v -> {
            String nombre = et_nombre.getText().toString();
            String telefono = et_telefono.getText().toString();

            if(!nombre.isBlank() && !telefono.isBlank()){
                registrarUsuario(nombre, telefono);
                et_telefono.setText("");
                et_nombre.setText("");
            }
        });

        dbHelper = new ConexionSQLite(this, "usuariosDB", null, 1);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void registrarUsuario(String nombre, String telefono) {
        Log.i("Volumi", "entra");
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("telefono", telefono);

        db.insert("usuarios", null, values);
        db.close();
    }
}