package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.nordikhat.uts.R;

public class EditarCarrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carros);
        Intent intent = getIntent();
        String name = intent.getStringExtra("placa");
        getSupportActionBar().setTitle("Editando Vehiculo: " + name);
    }
}