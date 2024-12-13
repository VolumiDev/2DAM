package com.volumidev.myfirstkotlinapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

        private val passwordsList = mutableMapOf<String, String>();
        private lateinit var et_nombreServicio: EditText;
        private lateinit var et_contraseña: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        et_nombreServicio = findViewById<EditText>(R.id.et_nombreServicio)
        et_contraseña = findViewById<EditText>(R.id.et_contraseña);

        val btn_añadirContraseña = findViewById<Button>(R.id.btn_añadirContraseña);
        val btn_verContraseñas = findViewById<Button>(R.id.btn_verContraseñas);
        val btn_buscarContraseña = findViewById<Button>(R.id.btn_buscarContraseña);

        val tv_resultado = findViewById<TextView>(R.id.tv_salida);


        btn_añadirContraseña.setOnClickListener {
            val service = et_nombreServicio.text.toString();
            val pass = et_contraseña.text.toString();

            if(validatePass(pass)){
                addPassword(service, pass);
                tv_resultado.text = "Contraseña añadida correctamente";
                clearInput();

            }else{
                tv_resultado.text = "Contraseña incorrecta";
                clearInput();

            }
        }

        btn_verContraseñas.setOnClickListener {
            tv_resultado.text = getAllPasswords();
        }

        btn_buscarContraseña.setOnClickListener {
            tv_resultado.text = searchPassword(et_nombreServicio.text.toString());
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getAllPasswords(): CharSequence? {
        return if(passwordsList.isEmpty()){
            "No hay contraseñas guardadas";
        }else{
            val result = StringBuilder();
            for( ( services, passwords ) in passwordsList){
                result.append("Servicio; $services - Contraseña: $passwords");
            }
            result.toString();
        }
    }

    private fun addPassword(service: String, pass: String) {
        if(service.isNotEmpty() && pass.isNotEmpty()){
            passwordsList[service] = pass;
        }
        Log.i("MainActivity", "Contraseñas guardadas: $passwordsList");
    }

    private fun validatePass(pass: String): Boolean {
        return when {
            pass.length < 8 -> false
            !pass.any { it.isDigit() } -> false
            !pass.any { it.isUpperCase() } -> false
            !pass.any { it.isLowerCase() } -> false
            else -> true
        }
    }

    private fun searchPassword(service: String): String? {
        return if(passwordsList.containsKey(service)){
            "La contraseña para el servicio $service es ${passwordsList[service]}";
        }else{
            "No hay contraseñas guardadas para el servicio $service";
        }
    }

    private fun clearInput(){
        et_contraseña.text.clear();
        et_nombreServicio.text.clear();
    }
}