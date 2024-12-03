package com.volumidev.videogameslib;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Clase que representa el controlador de deslizamiento para la lista de juegos.
 */
public class GameSearchSwipeController extends ItemTouchHelper.SimpleCallback{

    private GameRecyclerAdapter adapter;
    private Usuario user;

    private Drawable iconFav;
    private Drawable iconRemove;
    private final ColorDrawable backgroundFav;
    private final ColorDrawable backgroundRemove;


    /**
     * Constructor de la clase.
     * @param adapter
     * @param user
     */
    public GameSearchSwipeController(GameRecyclerAdapter adapter, Usuario user) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
        this.user = user;
        this.backgroundFav = new ColorDrawable(MyApp.getAppContext().getResources().getColor(R.color.yellow_500));
        this.backgroundRemove = new ColorDrawable(MyApp.getAppContext().getResources().getColor(R.color.redd_500));
        this.iconFav = MyApp.getAppContext().getResources().getDrawable(R.drawable.favoritos);
        this.iconRemove = MyApp.getAppContext().getResources().getDrawable(R.drawable.remove);
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    /**
     * Metodo que se ejecuta cuando se realiza un gesto de deslizamiento.
     * @param viewHolder The ViewHolder which has been swiped by the user.
     * @param direction  The direction to which the ViewHolder is swiped. It is one of
     *
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition(); //capturamos la posicion del elemento sobre el que estamos pulsando
        Game game = adapter.getGameList().get(position);

        //SI DESPLAZAMOS HACIA LA IZQUIERDA
        if (direction == ItemTouchHelper.LEFT) {
            removeFromList(position);
        } else if (direction == ItemTouchHelper.RIGHT) {
            //SI DESPLAZAMOS HACIA LA DERECHA
            addToFavorites(game);
            adapter.notifyItemChanged(position);
            Toast.makeText(MyApp.getAppContext(), "Juego añadido a favoritos", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Metodo que dibuja los elos elementos que aparecen debajo del RecyclerView al desplazarlos.
     *
     * @param c                 The canvas which RecyclerView is drawing its children
     * @param recyclerView      The RecyclerView to which ItemTouchHelper is attached to
     * @param viewHolder        The ViewHolder which is being interacted by the User or it was
     *                          interacted and simply animating to its original position
     * @param dX                The amount of horizontal displacement caused by user's action
     * @param dY                The amount of vertical displacement caused by user's action
     * @param actionState       The type of interaction on the View. Is either {@link
     * @param isCurrentlyActive True if this view is currently being controlled by the user or
     *                          false it is simply animating back to its original state.
     */
    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        //solo dibuja si es un gesto de desplazamiento
        if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            View itemView = viewHolder.itemView;
            //evita que el fonde se dibuje debajo de las esquinas redondeadas
            int backgroundCornerOffset = 20;

            if( dX > 0 ){
                backgroundFav.setBounds(itemView.getLeft(), itemView.getTop(),itemView.getLeft() + ((int) dX) + backgroundCornerOffset, itemView.getBottom());
                backgroundFav.draw(c);

                //calculamos la posicion del icono
                int iconMargin = (itemView.getHeight() - iconFav.getIntrinsicHeight()) / 2;
                int iconTop = itemView.getTop() + (itemView.getHeight() - iconFav.getIntrinsicHeight()) / 2;
                int iconLeft = itemView.getLeft() + iconMargin;
                int iconRight = itemView.getLeft() + iconMargin + iconFav.getIntrinsicWidth();
                int iconBottom = iconTop + iconFav.getIntrinsicHeight();

                if ( iconFav != null ){
                    iconFav.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                    iconFav.draw(c);
                }

            }else if ( dX < 0 ){
                backgroundRemove.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,
                        itemView.getTop(), itemView.getRight(), itemView.getBottom());
                backgroundRemove.draw(c);

                // Calcular posición del icono
                int iconMargin = (itemView.getHeight() - iconRemove.getIntrinsicHeight()) / 2;
                int iconTop = itemView.getTop() + (itemView.getHeight() - iconRemove.getIntrinsicHeight()) / 2;
                int iconBottom = iconTop + iconRemove.getIntrinsicHeight();

                int iconLeft = itemView.getRight() - iconMargin - iconRemove.getIntrinsicWidth();
                int iconRight = itemView.getRight() - iconMargin;

                // Dibujar el icono de añadir
                if (iconRemove != null) {
                    iconRemove.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                    iconRemove.draw(c);
                }
            }
        }
    }

    /**
     * Metodo que elimina un juego de la lista.
     * @param position
     */
    private void removeFromList(int position) {
        adapter.getGameList().remove(position);
        adapter.notifyItemRemoved(position);
        Toast.makeText(MyApp.getAppContext(), "Juego eliminado de la lista", Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo que añade un juego a la lista de favoritos.
     * @param game
     */
    private void addToFavorites(Game game) {
        Conexion con = Conexion.getInstance();
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", game.getName());
        values.put("url_img", game.getImage().getSmallUrl());
        values.put("id_usuario", user.getId());
        db.insert("videojuegos", null, values);
        db.close();
    }

}
