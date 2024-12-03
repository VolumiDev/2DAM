package com.volumidev.videogameslib;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

/**
 * @author Diego
 */
public class ProfileSwipeController extends ItemTouchHelper.SimpleCallback {
    private GameRecyclerAdapter adapter;
    private Usuario user;

    private Drawable iconRemove;
    private Drawable iconDetails;
    private final ColorDrawable backgroundRemove;
    private final ColorDrawable backgroundDetails;
    private List<Game> list_favGames;

    private Profile_Activity profileActivity;

    /**
     * Constructor de la clase
     * @param adapter
     * @param user
     * @param profileActivity
     */
    public ProfileSwipeController(GameRecyclerAdapter adapter, Usuario user, Profile_Activity profileActivity) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.profileActivity = profileActivity;
        this.adapter = adapter;
        this.user = user;
        this.backgroundRemove = new ColorDrawable(MyApp.getAppContext().getResources().getColor(R.color.redd_500));
        this.backgroundDetails = new ColorDrawable(MyApp.getAppContext().getResources().getColor(R.color.green_500));
        this.iconRemove = MyApp.getAppContext().getResources().getDrawable(R.drawable.remove);
        this.iconDetails = MyApp.getAppContext().getResources().getDrawable(R.drawable.detalles);
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }


    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition(); //capturamos la posicion del elemento sobre el que estamos pulsando
        Game game = adapter.getGameList().get(position);

        if (direction == ItemTouchHelper.LEFT) {
            showDetails(position);
            adapter.notifyItemChanged(position);
        } else if (direction == ItemTouchHelper.RIGHT) {
            showCustomDialog(position);
            adapter.notifyItemChanged(position);
            Toast.makeText(MyApp.getAppContext(), "Juego eliminado", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Dibuja los elementos de debajo del recilcerView cuando se desliza.
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
                backgroundRemove.setBounds(itemView.getLeft(), itemView.getTop(),itemView.getLeft() + ((int) dX) + backgroundCornerOffset, itemView.getBottom());
                backgroundRemove.draw(c);

                //calculamos la posicion del icono
                int iconMargin = (itemView.getHeight() - iconRemove.getIntrinsicHeight()) / 2;
                int iconTop = itemView.getTop() + (itemView.getHeight() - iconRemove.getIntrinsicHeight()) / 2;
                int iconLeft = itemView.getLeft() + iconMargin;
                int iconRight = itemView.getLeft() + iconMargin + iconRemove.getIntrinsicWidth();
                int iconBottom = iconTop + iconRemove.getIntrinsicHeight();

                if ( iconRemove != null ){
                    iconRemove.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                    iconRemove.draw(c);
                }

            }else if ( dX < 0 ){
                backgroundDetails.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,
                        itemView.getTop(), itemView.getRight(), itemView.getBottom());
                backgroundDetails.draw(c);

                // Calcular posición del icono
                int iconMargin = (itemView.getHeight() - iconDetails.getIntrinsicHeight()) / 2;
                int iconTop = itemView.getTop() + (itemView.getHeight() - iconDetails.getIntrinsicHeight()) / 2;
                int iconBottom = iconTop + iconDetails.getIntrinsicHeight();

                int iconLeft = itemView.getRight() - iconMargin - iconDetails.getIntrinsicWidth();
                int iconRight = itemView.getRight() - iconMargin;

                // Dibujar el icono de añadir
                if (iconDetails != null) {
                    iconDetails.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                    iconDetails.draw(c);
                }
            }
        }
    }

    /**
     * Muestra los detalles del juego
     * @param position
     */
    private void showDetails(int position) {
        Game g = adapter.getGameList().get(position);
        DetailsDialog dialog = new DetailsDialog(profileActivity);
        dialog.showDialog(g);
    }

    /**
     * Elimina el juego de la lista
     * @param position
     */
    private void removeFromList(int position) {
        String title = adapter.getGameList().get(position).getName();
        int userid = user.getId();
        adapter.removeItem(position);
        Conexion con = Conexion.getInstance();
        SQLiteDatabase db = con.getWritableDatabase();
        String sql = "DELETE FROM videojuegos WHERE id_usuario = " + userid + " AND titulo = '" + title + "'";
        System.out.println(sql);
        db.execSQL(sql);
    }

    /**
     * Muestra el dialogo personalizado
     * @param position
     */
    private void showCustomDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(profileActivity);

        // Inflar el diseño personalizado
        View customView = LayoutInflater.from(MyApp.getAppContext()).inflate(R.layout.dialog_custom, null);
        builder.setView(customView);

        // Configurar los botones en el diseño
        Button btnCancel = customView.findViewById(R.id.btn_no);
        btnCancel.setBackgroundColor(MyApp.getAppContext().getResources().getColor(R.color.redd_500));
        Button btnConfirm = customView.findViewById(R.id.btn_yes);
        btnConfirm.setBackgroundColor(MyApp.getAppContext().getResources().getColor(R.color.green_500));

        // Crear el diálogo
        AlertDialog dialog = builder.create();
        dialog.create();

        // Configurar acciones de los botones
        btnCancel.setOnClickListener(view -> {
            dialog.dismiss();
        });

        btnConfirm.setOnClickListener(view -> {
            // Acción al presionar "Sí"
            removeFromList(position);
            dialog.dismiss();
        });
        dialog.show();
    }
}
