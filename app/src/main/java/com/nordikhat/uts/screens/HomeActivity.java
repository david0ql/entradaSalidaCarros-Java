package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.nordikhat.uts.R;

public class HomeActivity extends AppCompatActivity {
    Button verCarros, editarCarros, insertarCarros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Panel administrativo");

        verCarros = findViewById(R.id.verCarros);
        editarCarros = findViewById(R.id.editarCarros);
        insertarCarros = findViewById(R.id.insertarCarros);

        verCarros.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), VerCarrosActivity.class));
        });

        editarCarros.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), EditarCarrosActivity.class));
        });

        insertarCarros.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), InsertarCarrosActivity.class));
        });
    }
}