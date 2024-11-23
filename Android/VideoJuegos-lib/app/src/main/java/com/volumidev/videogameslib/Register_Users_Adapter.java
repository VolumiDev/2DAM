package com.volumidev.videogameslib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Register_Users_Adapter extends RecyclerView.Adapter<Register_Users_Adapter.UsersAdapterViewHolder> {

    private final List<Usuario> users_list;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public interface  OnItemClickListener {
        void onItemClick(Usuario user);
    }

    public Register_Users_Adapter(List<Usuario> usersList, Context context) {
        users_list = usersList;
        this.context = context;
    }


    @NonNull
    @Override
    public UsersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.registered_users_card_item, parent, false);

        return new UsersAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapterViewHolder holder, int position) {
        Usuario user = users_list.get(position);
        holder.tv_card_user.setText(user.getNombre());

        holder.bind(user, onItemClickListener, this.context, users_list);
        holder.btn_delete_user.setOnClickListener(v->{
            removeItem(position, user);
        });
    }


    @Override
    public int getItemCount() {

        return users_list.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener= listener;
    }


    public void removeItem(int position, Usuario user){
        user.delete(context, user.getNombre());
        //eliminamos de la lista para que no se muestre
        users_list.remove(user);
        //notificamos al adapter
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, users_list.size());
    }




    public static class UsersAdapterViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_card_user;
        private Button btn_delete_user;

        public UsersAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_card_user = itemView.findViewById(R.id.tv_card_user);
            btn_delete_user = itemView.findViewById(R.id.btn_delete_user);
        }


        public void bind(Usuario user, OnItemClickListener onItemClickListener, Context context, List<Usuario> users_list) {
            tv_card_user.setText(user.getNombre());
            btn_delete_user.setBackgroundColor(itemView.getResources().getColor(R.color.redd_500));

            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(user));
        }
    }
}
