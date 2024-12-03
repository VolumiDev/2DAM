package com.volumidev.videogameslib;

import android.app.Application;
import android.content.Context;

/**
 * Clase que representa la aplicacion.
 * Creada para asi poder recoger el contexto desde cualquier punto de la app.
 */
public class MyApp extends Application {
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static MyApp getInstance() {
        return instance;
    }
    public static Context getAppContext() {
        return instance.getApplicationContext();
    }
}
