package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nordikhat.uts.R;

public class VerCarrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carros);
        getSupportActionBar().setTitle("Ver Carros");
    }
}