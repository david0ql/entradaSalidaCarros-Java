package com.nordikhat.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InsertarCarrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carros);
        getSupportActionBar().setTitle("Insertar Carros");
    }
}