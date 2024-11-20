package com.volumidev.videogameslib;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Usuario {
    private String nombre;
    private String contraseña;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.contraseña = pass;
    }


    /**
     * Metodo para insertar un usuario en la base de datos
     * @param context
     */
    public void insertar(Context context){
        Conexion sqliteHelper = new Conexion(context, "videogameslib", null, 1);
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        //alamacenamos los datos del usuario
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("contraseña", encriptarPass(contraseña));
        //insertamos los datos en la base de datos y cerramos conexion
        db.insert("usuarios", null, values);
        db.close();
    }

    private String encriptarPass(String pass){
        Argon2 argon2 = Argon2Factory.create();
        return argon2.hash(2, 65536, 1, pass.toCharArray());
    }

}
