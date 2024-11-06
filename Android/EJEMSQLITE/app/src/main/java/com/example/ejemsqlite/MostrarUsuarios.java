package com.example.ejemsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MostrarUsuarios extends AppCompatActivity {

    private RecyclerView rw_usuarios;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> listUsuarios;
    private ConexionSQLite dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recycler_view_mostrar_usuarios);

        rw_usuarios = findViewById(R.id.rw_usuarios);
        rw_usuarios.setLayoutManager(new LinearLayoutManager(this));

        listUsuarios = new ArrayList<>();
        dbHelper = new ConexionSQLite(this, "usuariosDB", null, 1);

        cargarUsuarios();
        usuarioAdapter = new UsuarioAdapter(listUsuarios);
        rw_usuarios.setAdapter(usuarioAdapter);
    }

    private void cargarUsuarios(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from usuarios";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String tlf = cursor.getString(2);
                listUsuarios.add(new Usuario(id, nombre, tlf));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }
}