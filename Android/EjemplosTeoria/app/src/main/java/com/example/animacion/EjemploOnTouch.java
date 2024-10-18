package com.example.animacion;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EjemploOnTouch extends AppCompatActivity implements View.OnTouchListener{

    private int corx, cory;
    private Lienzo fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejemplo_on_touch);

        corx = 100;
        cory = 100;

        ConstraintLayout layout =(ConstraintLayout) findViewById(R.id.layout1);

        fondo = new Lienzo(this, corx, cory);
        fondo.setOnTouchListener(this);
        layout.addView(fondo);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //fondo.corx = (int) event.getX();
        //fondo.cory = (int) event.getY();
        fondo.invalidate();
        return true;
    }
}