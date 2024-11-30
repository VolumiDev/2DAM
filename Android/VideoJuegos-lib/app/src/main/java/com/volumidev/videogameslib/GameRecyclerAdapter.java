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

public class GameRecyclerAdapter extends  RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder> {


    private List<Game> gameList;
    private OnItemClickListener onItemClickListener;
    private Context context;


    public interface OnItemClickListener{
        void onItemClick(Game game);
    }

    public GameRecyclerAdapter(List<Game> list, Context context){
        gameList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);

        //holder.tvGameName.setText(game.getName());
        //holder.tvReleaseYear.setText(game.getExpectedReleaseYear());
        //Glide.with(context).load(game.getImage().getSmallUrl()).into(holder.imgCover);

        holder.bind(game, onItemClickListener, this.context);

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public void setGamesList(List<Game> games) {
        if (games != null) {
            this.gameList = games;
        } else {
            this.gameList = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    //METODOS DE ACCION  DEL ELEMENTO DEL RECYCLER
    public void showInfo(int position) {
        Game game = this.gameList.get(position);
        Toast.makeText(null, "Nombre del juego: " + game.getName(), Toast.LENGTH_SHORT).show();
    }

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



    public class GameViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCover;
        private TextView tvGameName;
        private TextView tvReleaseYear;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.img_game_cover);
            tvGameName = itemView.findViewById(R.id.tv_game_name);
            tvReleaseYear = itemView.findViewById(R.id.tv_release_year);
        }

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
