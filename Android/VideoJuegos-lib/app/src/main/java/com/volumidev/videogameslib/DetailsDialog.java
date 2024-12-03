package com.volumidev.videogameslib;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;

/**
 * Clase que representa el diálogo de detalles del juego.
 */
public class DetailsDialog implements View.OnClickListener{
    private Profile_Activity profile_activity;
    private AlertDialog dialog;

    private EditText et_coment;
    private EditText et_category;
    private Spinner spinner_score;

    private Game game;

    /**
     * Constructor de la clase.
     * @param profile_activity
     */
    public DetailsDialog(Profile_Activity profile_activity) {
        this.profile_activity = profile_activity;
    }

    /**
     * Metodo que muestra el diálogo de detalles del juego.
     * @param game
     */
    public void showDialog(Game game){
        this.game = game;
        //INFLAMOS EL DISEÑO DEL CIADO EMERGENTE
        LayoutInflater inflater = LayoutInflater.from(MyApp.getAppContext());
        View dialogView = inflater.inflate(R.layout.game_details_dialog, null);

        //CONFIGURAMOS LOS ELEMENTOS DEL DIALOG
        ImageView img_game_cover = dialogView.findViewById(R.id.img_game_cover);
        TextView tv_game_name = dialogView.findViewById(R.id.tv_game_name);
        et_category = dialogView.findViewById(R.id.et_category);
        spinner_score = dialogView.findViewById(R.id.spinner_score);
        et_coment = dialogView.findViewById(R.id.et_coments);

        Button btn_acept = dialogView.findViewById(R.id.btn_acept);
        btn_acept.setBackgroundColor(MyApp.getAppContext().getResources().getColor(R.color.green_500));
        btn_acept.setOnClickListener(this);
        Button btn_close = dialogView.findViewById(R.id.btn_close);
        btn_close.setBackgroundColor(MyApp.getAppContext().getResources().getColor(R.color.redd_500));
        btn_close.setOnClickListener(this);


        //AÑADIMOS LAS IMAGENES AL ARRAY DE IMAGENES
        int[]images = {
                R.drawable.s,
                R.drawable.ss,
                R.drawable.sss,
                R.drawable.ssss,
                R.drawable.sssss,
        };

        //CONFIGURAMOS EL ADAPTADOR PERSONALIZADO
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(images);
        spinner_score.setAdapter(adapter);

        //AÑADIMOS LOS DATOS DEL JUEGO
        tv_game_name.setText(game.getName());
        Glide.with(MyApp.getAppContext()).load(game.getImage().getSmallUrl()).into(img_game_cover);
        loadingGameData();

        //CREAMOS EL DIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(profile_activity);
        builder.setView(dialogView);



        dialog = builder.create();
        dialog.show();
    }

    /**
     * Metodo que actualiza los datos del juego en la base de datos.
     * @param game
     */
    private void updateGame(@NonNull Game game){
        Conexion con = Conexion.getInstance();
        SQLiteDatabase db = con.getWritableDatabase();
        String sql = "UPDATE videojuegos SET categoria = '" + et_category.getText().toString() + "', puntuacion = "+ spinner_score.getSelectedItemId() +
                ", comentario = '" + et_coment.getText().toString() + "' WHERE titulo like '"+ game.getName() +"'";
        db.execSQL(sql);
    }

    /**
     * Metodo que carga los datos del juego de la base de datos.
     */
    private void loadingGameData(){
        Conexion con = Conexion.getInstance();
        SQLiteDatabase db = con.getReadableDatabase();
        String sql = "SELECT * FROM videojuegos WHERE titulo like '" + game.getName() + "' ";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                et_category.setText(cursor.getString(2));
                spinner_score.setSelection(cursor.getInt(3));
                et_coment.setText(cursor.getString(4));
            }while (cursor.moveToNext());
        }

    }

    /**
     * Metodo que se ejecuta cuando se hace clic en un elemento del diálogo.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_acept:
                    updateGame(game);
                    dialog.dismiss();
                break;

                case R.id.btn_close:
                    dialog.dismiss();
                    break;
        }
    }


}
