package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.nordikhat.uts.R;

public class HomeActivity extends AppCompatActivity {
    Button verCarros, insertarCarros;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Panel administrativo");
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        verCarros = findViewById(R.id.verCarros);
        insertarCarros = findViewById(R.id.insertarCarros);
        textView = findViewById(R.id.textView);
        textView.setText("Bienvenido al panel " + name);
        verCarros.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), VerCarrosActivity.class));
        });


        insertarCarros.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), InsertarCarrosActivity.class));
        });
    }
}