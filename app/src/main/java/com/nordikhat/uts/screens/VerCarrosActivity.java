package com.nordikhat.uts.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nordikhat.uts.R;
import com.nordikhat.uts.api.ApiClass;
import com.nordikhat.uts.services.leerVehiculos.ReadVehiculoClient;
import com.nordikhat.uts.services.leerVehiculos.VehicleResponse;
import com.nordikhat.uts.services.leerVehiculos.VehicleResponseClass;
import com.nordikhat.uts.services.verVehiculos.adapter.VehiculosAdapter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VerCarrosActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ReadVehiculoClient readVehiculoClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carros);
        getSupportActionBar().setTitle("Ver Carros");
        recyclerView = findViewById(R.id.recyclerview);
        setup();




    }

    void setup() {
       readVehiculoClient = readVehiculoClient.getInstance();
       try {
           readVehiculoClient.getReadVehicleService().readVehicles().enqueue(new Callback<VehicleResponse>() {
               @Override
               public void onResponse(@NonNull Call<VehicleResponse> call, Response<VehicleResponse> r) {
                   recyclerView.setAdapter(new VehiculosAdapter(getApplicationContext(), r.body().getVehicleResponse().getVehicle()));
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
}