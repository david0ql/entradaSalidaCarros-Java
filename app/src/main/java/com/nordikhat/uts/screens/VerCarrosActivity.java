package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.nordikhat.uts.R;
import com.nordikhat.uts.services.verVehiculos.adapter.VehiculosAdapter;

public class VerCarrosActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carros);
        getSupportActionBar().setTitle("Ver Carros");
        recyclerView = findViewById(R.id.recyclerview);

        //recyclerView.setAdapter(new VehiculosAdapter(new Veh);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }
}