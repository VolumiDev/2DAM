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

    private ImageView[] arrImgV;

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
                Toast.makeText(this, "CLIC" +v.getId(), Toast.LENGTH_SHORT).show();
                Log.i("Volumi", "action down");
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(data, shadowBuilder, v, 0);
                break;
            //EVENTO DE SAOLTAR
            case MotionEvent.ACTION_MOVE:
                Toast.makeText(this, "CLIC", Toast.LENGTH_SHORT).show();
                Log.i("Volumi", "action up");
                ImageView imageViewSeleccionada = (ImageView) v;
                ImageView target = getTargetImageView(imageViewSeleccionada);
                if (target != null){
                    if(compararImagesView(imageViewSeleccionada.getDrawable(), target.getDrawable())){
                        imageViewSeleccionada.setVisibility(View.GONE);
                        target.setVisibility(View.GONE);
                    }else{
                        Toast.makeText(this, "Las imagenes no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

        return false;
    }


   public ImageView getTargetImageView(ImageView dragedImageView){
       Rect dragRect = new Rect();
       dragedImageView.getHitRect(dragRect);

       for (ImageView iv : arrImgV){
           if(iv != dragedImageView && iv.getVisibility() == View.VISIBLE){
               Rect targetRect = new Rect();
               iv.getHitRect(targetRect);
               if(Rect.intersects(dragRect,targetRect)){
                   return iv;
               }
           }
       }
       return null;
   }

   private void inicializarImagesView(){
        arrImgV = new ImageView[9];
       for (int i = 0; i < arrImgV.length; i++) {
           String iv_Id = "iv_"+i;
           int res_Id = getResources().getIdentifier(iv_Id, "id", getPackageName());
           arrImgV[i] = findViewById(res_Id);
           arrImgV[i].setOnTouchListener(this);
       }
   }

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