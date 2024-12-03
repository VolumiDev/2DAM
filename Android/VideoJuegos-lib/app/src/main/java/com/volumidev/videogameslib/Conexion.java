package com.volumidev.videogameslib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Clase que representa la conexión a la base de datos. La instanciamos con Singleton y la usamos en toda la app.
 */
public class Conexion extends SQLiteOpenHelper {
    //CREACION DE LAS TABLAS
    private static final String CREATE_USUARIOS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS usuarios (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "nombre TEXT NOT NULL, " +
            "contraseña TEXT NOT NULL); ";

    private static final String CREATE_JUEGO_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS videojuegos (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "titulo text NOT NULL, " +
            "categoria TEXT, " +
            "puntuacion INTEGER, " +
            "comentario TEXT, " +
            "url_img TEXT, " +
            "id_usuario INTEGER, " +
            "FOREIGN KEY (id_usuario) " +
            "REFERENCES usuarios(id) " +
            "ON DELETE CASCADE " +
            "ON UPDATE CASCADE );";
    private static final String DATABASE_NAME = "videogameslib";
    private static final int DATABASE_VERSION = 1;

    private static Conexion instance;


    private Conexion(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // SINGLETON. INSTANCIA UNICA PARA TODA LA APP
    public static synchronized Conexion getInstance(){
        if (instance == null){
            instance = new Conexion(MyApp.getAppContext());
        }
        return instance;
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
