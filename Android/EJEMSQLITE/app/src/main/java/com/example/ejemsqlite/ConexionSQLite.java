package com.example.ejemsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    private static final String CREAR_TABLA_USUARIOS = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT)";

    public ConexionSQLite(@Nullable Context context, @Nullable String dbName, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //EJECUTAMOS LA SENTENCIA DE CREACION ALAMACENADA
        db.execSQL(CREAR_TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //BORRAMOS LA TABLA Y LA VOLVEMO A INICIAR
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
