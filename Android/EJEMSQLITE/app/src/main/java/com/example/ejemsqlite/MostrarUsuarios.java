package com.example.ejemsqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
        usuarioAdapter.setOnItemClickListener(new UsuarioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Usuario usuario) {
                mostrarDialogoEditarUsuario(usuario);
            }
        });
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

    private void mostrarDialogoEditarUsuario(Usuario usuario){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Editar Telefono");

        //INFLA LA VISTA PERSONALIZADA PARA EL DIALOGO
        View dialogView = getLayoutInflater().inflate(R.layout.editar_datos, null);
        builder.setView(dialogView);

        TextView nombreTextView = dialogView.findViewById(R.id.tv_editar_datos);
        EditText tlfEditText = dialogView.findViewById(R.id.et_editar_datos);

        nombreTextView.setText(usuario.getNombre());
        tlfEditText.setText(usuario.getTelefono());

        builder.setPositiveButton("Guardar", (dialog, which)->{
            String nuevoTelefono = tlfEditText.getText().toString();
            actualizarTelefono(usuario.getId(), nuevoTelefono);
        });

        builder.setNegativeButton("Cancelar", (dialog, wich) -> {
            dialog.dismiss();
        });
        builder.create().show();
    }


    private void actualizarTelefono(int usuarioId, String nuevoTelefono) {
        SQLiteDatabase db  = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("telefono", nuevoTelefono);

        db.update("usuarios", values, "id = ?", new String[]{String.valueOf(usuarioId)});
        db.close();

        for (Usuario user : listUsuarios){
            if(user.getId() == usuarioId){
                user.setTelefono(nuevoTelefono);
                break;
            }
        }
        usuarioAdapter.notifyDataSetChanged();
    }
}