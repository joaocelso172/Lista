package com.example.lista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lista.R;
import com.example.lista.model.Carro;

import java.util.List;

public class adapterCar extends RecyclerView.Adapter<adapterCar.MyVielHolder> {

    private List<Carro> listaCARROS;

    public adapterCar(List<Carro> lista) {

        this.listaCARROS = lista;

    }

    @NonNull
    @Override
    public MyVielHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLIsta = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_carro_adapter, parent, false);

        return new MyVielHolder(itemLIsta);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVielHolder holder, int position) {

        Carro carro = listaCARROS.get(position);
        holder.txtcarro.setText(carro.getNomeCarro());
        holder.imgModel.setImageResource(carro.getModeloCar());

    }

    @Override
    public int getItemCount() {
        return this.listaCARROS.size();
    }

    public class MyVielHolder extends RecyclerView.ViewHolder{

        TextView txtcarro;
        ImageView imgModel;

        public MyVielHolder(@NonNull View itemView) {
            super(itemView);

            txtcarro = itemView.findViewById(R.id.textMarca);
            imgModel = itemView.findViewById(R.id.imageModelo);

        }
    }
}
