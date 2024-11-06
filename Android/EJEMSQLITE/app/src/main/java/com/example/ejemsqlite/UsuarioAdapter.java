package com.example.ejemsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private final List<Usuario> usuariosList;

    public UsuarioAdapter(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario user = usuariosList.get(position);
        holder.tv_nombre.setText(user.getNombre());
        holder.tv_telefono.setText(user.getTelefono());
    }


    //CONTAMOS LOS ELEMENTOS QUE TIENE LA LISTA
    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    // ES LA CLASE ENCARGADA DE PINTAR CADA ITEM CARD. LE TENEMOS QUE PASAR CADA UNO DE LOS ELEMENTOS
    //QUE QUEREMOS QUE NOS PINTE EN LA TARJETA.
    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nombre, tv_telefono;
        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tvCard_nombre);
            tv_telefono = itemView.findViewById(R.id.tvCard_telefono);
        }
    }
}
