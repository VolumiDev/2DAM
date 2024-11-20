package com.volumidev.videogameslib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {
    private static final String CREATE_USUARIOS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS usuarios (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "nombre TEXT NOT NULL, " +
            "contraseña TEXT NOT NULL); ";

    private static final String CREATE_JUEGO_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS videojuegos (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "titulo text NOT NULL, " +
            "categoria TEXT NOT NULL, " +
            "puntuacion INTEGER, " +
            "comentario TEXT, " +
            "id_usuario INTEGER, " +
            "FOREIGN KEY (id_usuario) " +
            "REFERENCES usuarios(id) " +
            "ON DELETE CASCADE " +
            "ON UPDATE CASCADE );";





    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //ejecutamos la sentencia de creación de la base de datos
        db.execSQL(CREATE_USUARIOS_TABLE_QUERY);
        db.execSQL(CREATE_JUEGO_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
