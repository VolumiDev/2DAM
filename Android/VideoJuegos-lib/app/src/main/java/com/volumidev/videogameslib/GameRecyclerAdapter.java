package com.volumidev.videogameslib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el adaptador del RecyclerView de juegos.
 */
public class GameRecyclerAdapter extends  RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder> {


    private List<Game> gameList;
    private OnItemClickListener onItemClickListener;
    private Context context;

    /**
     * Interfaz que representa el click en un elemento del RecyclerView.
     */
    public interface OnItemClickListener{
        void onItemClick(Game game);
    }

    /**
     * Constructor de la clase.
     * @param list
     * @param context
     */
    public GameRecyclerAdapter(List<Game> list, Context context){
        gameList = list;
        this.context = context;
    }

    /**
     * Metodo que se ejecuta cuando se crea un nuevo ViewHolder.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_game, parent, false);
        return new GameViewHolder(view);
    }

    /**
     * Metodo que se ejecuta cuando se necesita actualizar el contenido de un ViewHolder.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        holder.bind(game, onItemClickListener, this.context);
    }

    /**
     * Metodo que devuelve el número de elementos en la lista.
     * @return
     */
    @Override
    public int getItemCount() {
        return gameList.size();
    }

    /**
     * Metodo que actualiza la lista de juegos.
     * @param games
     */
    public void setGamesList(List<Game> games) {
        if (games != null) {
            this.gameList = games;
        } else {
            this.gameList = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    /**
     * Metodo que muestra la información de un juego.
     * @param position
     */
    public void showInfo(int position) {
        Game game = this.gameList.get(position);
        Toast.makeText(null, "Nombre del juego: " + game.getName(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo que elimina un juego de la lista.
     * @param position
     */
    public void removeItem(int position) {
        this.gameList.remove(position);
        notifyItemRemoved(position);
    }





    //getters & setters
    public List<Game> getGameList() {
        return gameList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }


    /**
     * Clase que representa el ViewHolder del RecyclerView.
     */
    public class GameViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCover;
        private TextView tvGameName;
        private TextView tvReleaseYear;

        /**
         * Constructor de la clase.
         * @param itemView
         */
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.img_game_cover);
            tvGameName = itemView.findViewById(R.id.tv_game_name);
            tvReleaseYear = itemView.findViewById(R.id.tv_release_year);
        }

        /**
         * Metodo que se ejecuta cuando se crea un nuevo ViewHolder.
         * @param game
         * @param onItemClickListener
         * @param context
         */
        public void bind(Game game, OnItemClickListener onItemClickListener, Context context){
            tvGameName.setText(game.getName());
            String releaseDate  = game.getOriginalReleaseDate();
            if(releaseDate == null || releaseDate.isEmpty()){
                tvReleaseYear.setVisibility(View.GONE);
            } else {
                tvReleaseYear.setText(releaseDate);
            }
            Image image = game.getImage();

            if(image != null && image.getSmallUrl() != null){
                Glide.with(context).load(image.getSmallUrl()).into(imgCover);
            }else{
                imgCover.setImageResource(R.drawable.error);
            }

            itemView.setOnClickListener(v -> {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(game);
                }
            });
        }
    }
}
