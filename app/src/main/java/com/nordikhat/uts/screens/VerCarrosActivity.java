package com.nordikhat.uts.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nordikhat.uts.R;
import com.nordikhat.uts.api.ApiClass;
import com.nordikhat.uts.services.leerVehiculos.ReadVehiculoClient;
import com.nordikhat.uts.services.leerVehiculos.Vehicle;
import com.nordikhat.uts.services.leerVehiculos.VehicleResponse;
import com.nordikhat.uts.services.leerVehiculos.VehicleResponseClass;
import com.nordikhat.uts.services.verVehiculos.adapter.VehiculosAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VerCarrosActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    SearchView mSearchView;
    ReadVehiculoClient readVehiculoClient;
    List<Vehicle> vehicles;
    List<Vehicle> vehiclesSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carros);
        getSupportActionBar().setTitle("Ver Carros");
        recyclerView = findViewById(R.id.recyclerview);
        mSearchView = findViewById(R.id.search_view);
        mSearchView.setOnQueryTextListener(this);
        setup();

    }

    void setup() {
        readVehiculoClient = readVehiculoClient.getInstance();
        try {
            readVehiculoClient.getReadVehicleService().readVehicles().enqueue(new Callback<VehicleResponse>() {
                @Override
                public void onResponse(@NonNull Call<VehicleResponse> call, Response<VehicleResponse> r) {
                    assert r.body() != null;
                    vehiclesSnapshot = Arrays.asList(r.body().getVehicleResponse().getVehicle());
                    vehicles = Arrays.asList(r.body().getVehicleResponse().getVehicle());
                    recyclerView.setAdapter(new VehiculosAdapter(getApplicationContext(), vehicles));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onFailure(@NonNull Call<VehicleResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "fail:" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        } catch (Exception e) {
            Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle item : vehicles) {
            if (item.getPlate().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        vehicles = filteredList;
        recyclerView.setAdapter(new VehiculosAdapter(getApplicationContext(), vehicles));
        recyclerView.getAdapter().notifyDataSetChanged();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.length() == 0){
            recyclerView.setAdapter(new VehiculosAdapter(getApplicationContext(), vehiclesSnapshot));
            recyclerView.getAdapter().notifyDataSetChanged();
        }
        return false;
    }
}