package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nordikhat.uts.R;

public class EliminarCarrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_carros);
        getSupportActionBar().setTitle("Insertar Carros");
    }
}