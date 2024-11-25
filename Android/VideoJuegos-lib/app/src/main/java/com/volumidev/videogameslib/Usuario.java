package com.volumidev.videogameslib;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String password;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.password = pass;
    }

    public Usuario() {

    }


    /**
     * Metodo para insertar un usuario en la base de datos
     *
     * @param context
     */
    public void insertar(Context context) {
        Conexion sqliteHelper = new Conexion(context, "videogameslib", null, 1);
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        //alamacenamos los datos del usuario
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("contraseña", encriptarPass(password));
        //insertamos los datos en la base de datos y cerramos conexion
        db.insert("usuarios", null, values);
        db.close();
    }


    /**
     * Metodo a el que le pasamos la contraseña que introduce el usuario la converticmos en un hash que es el que almacenamos.
     *
     * @param pass
     * @return la contraseña hasheada
     */
    public String encriptarPass(String pass) {

        try {
            // Crear instancia de SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(pass.getBytes());

            // Convertir los bytes del hash a un formato hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }


    public Usuario getUsuarioFromDB(Context context, String sql) {
        Conexion sqliteHelper = new Conexion(context, "videogameslib", null, 1);
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                this.nombre = cursor.getString(1);
                this.password = cursor.getString(2);
            } while (cursor.moveToNext());
        } else {
            this.nombre = null;
        }
        cursor.close();
        db.close();
        return this;
    }


    public List<Usuario> getUsuariosFromDB(Context context) {
        List<Usuario> list = new ArrayList<>();
        Conexion sqliteHelper = new Conexion(context, "videogameslib", null, 1);
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String sql = "SELECT * FROM usuarios";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Usuario u = new Usuario(cursor.getString(1), null);
                list.add(u);
            }

        }else {
            Toast.makeText(context, "Base de datos vacia", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        db.close();
        return list;
    }


    /**
     * Metodo para borrar un usuario de la base de datos
     * @param context
     * @param nombre
     */
    public void delete(Context context, String nombre) {
        Conexion sqliteHelper = new Conexion(context, "videogameslib", null, 1);
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        String sql = "DELETE FROM usuarios WHERE nombre = ?";
        db.execSQL(sql, new String[]{nombre});
        db.close();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
