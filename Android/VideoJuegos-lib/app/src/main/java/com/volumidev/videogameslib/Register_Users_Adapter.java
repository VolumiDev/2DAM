package com.volumidev.videogameslib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author Diego
 */
public class Register_Users_Adapter extends RecyclerView.Adapter<Register_Users_Adapter.UsersAdapterViewHolder> {

    private final List<Usuario> users_list;
    private OnItemClickListener onItemClickListener;
    private Context context;

    /**
     * Interfaz para el click en el item
     */
    public interface  OnItemClickListener {
        void onItemClick(Usuario user);
    }

    /**
     * Constructor de la clase
     * @param usersList
     * @param context
     */
    public Register_Users_Adapter(List<Usuario> usersList, Context context) {
        users_list = usersList;
        this.context = context;
    }

    /**
     * Crea el ViewHolder
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public UsersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.registered_users_card_item, parent, false);

        return new UsersAdapterViewHolder(view);
    }

    /**
     * Actualiza el ViewHolder
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull UsersAdapterViewHolder holder, int position) {
        Usuario user = users_list.get(position);
        holder.tv_card_user.setText(user.getNombre());

        holder.bind(user, onItemClickListener, this.context, users_list);
        holder.btn_delete_user.setOnClickListener(v->{
            removeItem(position, user);
        });
    }

    /**
     * Devuelve el numero de elementos de la lista
     * @return
     */
    @Override
    public int getItemCount() {

        return users_list.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener= listener;
    }

    /**
     * Elimina el item de la lista
     * @param position
     * @param user
     */
    public void removeItem(int position, Usuario user){
        user.delete(context, user.getNombre());
        //eliminamos de la lista para que no se muestre
        users_list.remove(user);
        //notificamos al adapter
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, users_list.size());
    }


    /**
     * ViewHolder personalizado
     */
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
