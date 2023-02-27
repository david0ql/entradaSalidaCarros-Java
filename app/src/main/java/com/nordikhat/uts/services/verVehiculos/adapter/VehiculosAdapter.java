package com.nordikhat.uts.services.verVehiculos.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nordikhat.uts.R;
import com.nordikhat.uts.screens.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehiculosAdapter extends RecyclerView.Adapter<VehiculosAdapter.ViewHolderHist> {


    List<Vehicle> vehicles = new ArrayList<>();

    public VehiculosAdapter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @NonNull
    @Override
    public VehiculosAdapter.ViewHolderHist onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculosAdapter.ViewHolderHist holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolderHist extends RecyclerView.ViewHolder {

        TextView placa, tipo, nombre;

        public ViewHolderHist(View itemView) {
            super(itemView);
            placa = itemView.findViewById(R.id.placa);
            tipo = itemView.findViewById(R.id.tipo);
            nombre = itemView.findViewById(R.id.nombre);

        }

        public void setVehicle(){

        }

    }
}
