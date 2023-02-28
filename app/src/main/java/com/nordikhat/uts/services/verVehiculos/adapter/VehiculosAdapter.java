package com.nordikhat.uts.services.verVehiculos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nordikhat.uts.R;
import com.nordikhat.uts.screens.EditarCarrosActivity;
import com.nordikhat.uts.services.leerVehiculos.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehiculosAdapter extends RecyclerView.Adapter<VehiculosAdapter.ViewHolderHist> {


    private Context mContext;
    com.nordikhat.uts.services.leerVehiculos.Vehicle[] vehicles;

    public VehiculosAdapter(Context mContext, Vehicle[] vehicles) {
        this.mContext = mContext;
        this.vehicles = vehicles;
    }

    @NonNull
    @Override
    public VehiculosAdapter.ViewHolderHist onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolderHist(inflater.from(mContext).inflate(R.layout.card, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull VehiculosAdapter.ViewHolderHist holder, int position) {
        holder.placa.setText(vehicles[position].getPlate());
        holder.nombre.setText(vehicles[position].getName());
        holder.tipo.setText(vehicles[position].getType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, EditarCarrosActivity.class);
                i.putExtra("placa", vehicles[holder.getAdapterPosition()].getPlate());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vehicles.length;
    }

    public class ViewHolderHist extends RecyclerView.ViewHolder {

        TextView placa, tipo, nombre;

        public ViewHolderHist(View itemView) {
            super(itemView);

            placa = itemView.findViewById(R.id.placa);
            tipo = itemView.findViewById(R.id.tipo);
            nombre = itemView.findViewById(R.id.nombre);


        }


    }

    public void setCard() {

    }
}
