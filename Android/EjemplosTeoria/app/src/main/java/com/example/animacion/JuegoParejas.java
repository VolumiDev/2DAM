package com.example.animacion;

import android.content.ClipData;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JuegoParejas extends AppCompatActivity implements View.OnTouchListener{

    //ARRAY CON LAS IMAGENES QUE CONTENEMOS EN LA VISTA
    private ImageView[] arrImgV;
    // VARIABLES DONDE ALMACENAREMOS LAS CORDENADAS DE LA VISTA
    float touchX, touchY, originX, originY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juego_parejas);

        //INICIALIZAMOS LOS IMAGES VIEW
        inicializarImagesView();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            //EVENTO DE APRETAR Y MANTENER
            case MotionEvent.ACTION_DOWN:
                //TRAEMOS AL FRENTE LA IMAGEN PARA QUE VAYA POR ENCIMA DE LAS DEMAS
                v.bringToFront();
                //CAPTURAMOS LAS COORDENADAS DEL TOUCH, EXACTAMENTE DENTRO DE LA VISTA QUE GENERO EL EVENTO
                touchX = event.getRawX() - v.getX();
                touchY = event.getRawY() - v.getY();
                //CAPTURAMOS LAS COORDENADAS DE LA IMAGEN SOBRE LA QUE HACEMOS TOUCH
                originX = v.getX();
                originY = v.getY();



//                ClipData data = ClipData.newPlainText("","");
//                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
//                v.startDragAndDrop(data, shadowBuilder, v, 0);
            //EVENTO DE MOVER
            case MotionEvent.ACTION_MOVE:
                //CAPTURAMOS LA POSICION DE LA VISTA
                float newX = event.getRawX() - touchX;
                float newY = event.getRawY() - touchY;

                //LIMITAMOS EL MOVIMIENTO DENTRO DEL PADRE
                View parent = (View) v.getParent();
                int parentWith = parent.getWidth();
                int parentHeight = parent.getHeight();

                newX = Math.max(0, Math.min(newX, parentWith - v.getWidth()));
                newY = Math.max(0, Math.min(newY, parentHeight - v.getHeight()));
                //SETEAMOS LAS NUEVAS COORDENADAS DE LA IMAGEN
                v.setX(newX);
                v.setY(newY);
                return true;
                // EVENTO DE SOLTAR EL BOTON
            case MotionEvent.ACTION_UP:
                //CONVERTIMOS EN OBJETIVO LA IMAGEN SOBRE LA QUE DEJAMOS CAER LA IMAGEN ARRASTRADA
                ImageView targetIv = getTargetImageView((ImageView) v);
                if(targetIv != null){
                    //COMPARAMOS LOS DRAWABLES Y LOS HACEMOS DESPARECER SI SON IGUALES.
                    if(compararImagesView(((ImageView) v).getDrawable(), targetIv.getDrawable())){
                        v.setVisibility(View.GONE);
                        targetIv.setVisibility(View.GONE);
                    }else{
                        //SI NO SON IGUALES DEVOLVEMOS LA IMAGEN A SU POSICION INICIAL
                        v.setX(originX);
                        v.setY(originY);
                    }
                } else {
                    v.setX(originX);
                    v.setY(originY);
                }
                return true;
        }
        return false;
    }


   public ImageView getTargetImageView(ImageView dragedImageView){
        //GENERAMOS UN RECTANGULO
       Rect dragRect = new Rect();
       //ASIGNAMOS EL EL RECTANGULO DE LA IMAGEN ARRASTRADA A DICHO RECTANGULO
       dragedImageView.getHitRect(dragRect);
        //RECORREMOS EL ARRAY DE IMAGENES
       for (ImageView iv : arrImgV){
           //SI LA VISTA ES DISTINTA QUE LA QUE ARRASTRAMOS Y ESTA EN VISIBLE SERA TRUE
           if(iv != dragedImageView && iv.getVisibility() == View.VISIBLE){
               //GENERAMOS UN NUEVO AREA
               Rect targetRect = new Rect();
               //ASIGNAMOS EL AREA A LA IMAGEN QUE ESTAMOS COMPROBANDO
               iv.getHitRect(targetRect);
               //SI AMBAS AREAS SE CORTAN EN ALGUN PUNTO RETORNAMOS LA VISTA PARA TRATAR CON ELLA.
               if(Rect.intersects(dragRect,targetRect)){
                   return iv;
               }
           }
       }
       return null;
   }
//INICIALIZAMOS LAS IMAGENES DENTRO DEL ARRAY CON LAS ID Y LOS EVENTOS
   private void inicializarImagesView(){
        arrImgV = new ImageView[9];
       for (int i = 0; i < arrImgV.length; i++) {
           String iv_Id = "iv_"+i;
           int res_Id = getResources().getIdentifier(iv_Id, "id", getPackageName());
           arrImgV[i] = findViewById(res_Id);
           arrImgV[i].setOnTouchListener(this);
       }
   }
//COMPARAMOS DOS DRAWABLES SI SON DISTINTOS DE NULL
   private boolean compararImagesView(Drawable drawable1, Drawable drawable2){
       Log.i("Volumi", "drawablw 1: "+drawable1);
       Log.i("Volumi", "drawablw 1: "+drawable2);
        if(drawable1 == null || drawable2 == null){
            return false;
       }else{
            return drawable1.getConstantState().equals(drawable2.getConstantState());
        }
   }
}