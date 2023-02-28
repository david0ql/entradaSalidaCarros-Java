package com.nordikhat.uts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nordikhat.uts.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EditarCarrosActivity extends AppCompatActivity {
    private TextView textplaca, textnombre, texttipo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carros);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Intent intent = getIntent();
        String name = intent.getStringExtra("nombre");
        String placa = intent.getStringExtra("placa");
        String tipo = intent.getStringExtra("tipo");
        String id = intent.getStringExtra("id");

        textplaca = findViewById(R.id.placa);
        textnombre = findViewById(R.id.nombre);
        texttipo = findViewById(R.id.tipo);

        textnombre.setText(name);
        textplaca.setText(placa);
        texttipo.setText(tipo);
        button = findViewById(R.id.button);
        getSupportActionBar().setTitle("Editando Vehiculo: " + name);

        button.setOnClickListener(view -> {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .followRedirects(false)
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");

            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://192.168.1.5:8080/v1/updateVehicleById/" + id)
                    .method("PUT", body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                System.out.println(response.body().string());
                Toast.makeText(this, "Se ha actualizado con exito", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), VerCarrosActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}