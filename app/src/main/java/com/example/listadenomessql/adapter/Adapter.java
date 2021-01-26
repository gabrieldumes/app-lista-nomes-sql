package com.example.listadenomessql.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadenomessql.R;
import com.example.listadenomessql.model.Nome;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Nome> listaNomes;

    public Adapter(List<Nome> listaNomes) {
        this.listaNomes = listaNomes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Nome nome = listaNomes.get(position);
        holder.textNome.setText(nome.getNome());
    }

    @Override
    public int getItemCount() {
        return listaNomes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.textNomeLista);
        }
    }
}
