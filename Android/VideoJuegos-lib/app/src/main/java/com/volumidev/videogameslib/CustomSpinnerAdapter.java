package com.volumidev.videogameslib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Clase que representa el adaptador personalizado para el spinner de estrellas.
 */
public class CustomSpinnerAdapter extends BaseAdapter {


    private int[] star;

    public CustomSpinnerAdapter(int[] star) {
        this.star = star;
    }

    @Override
    public int getCount() {
        return star.length;
    }

    @Override
    public Object getItem(int position) {
        return star[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(MyApp.getAppContext()).inflate(R.layout.spiner_stars_layout, parent, false);
            ImageView imageView = convertView.findViewById(R.id.img_star);
            imageView.setImageResource(star[position]);
        }
        return convertView;
    }
}
