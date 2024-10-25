package com.example.animacion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

 class Lienzo extends View {
     Paint pincel;
     Path path;

     //int corx, cory;
    public Lienzo(Context context, int cx, int cy) {
        super(context);

        //corx = cx;
        //cory = cy;
    }

    private void inicializarPincel(){
        pincel = new Paint();
        pincel.setColor(Color.BLACK);
        pincel.setAntiAlias(true);
        pincel.setStrokeWidth(10);
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setStrokeJoin(Paint.Join.ROUND);

    }



    protected void onDraw(Canvas canvas){
        canvas.drawRGB(255,255,0);
        Paint pincel1 = new Paint();
        pincel1.setARGB(255,255,0,0);
        pincel1.setStrokeWidth(4);
        pincel1.setStyle(Paint.Style.STROKE);
        //canvas.drawCircle(corx,cory,20,pincel1);

    }
}
