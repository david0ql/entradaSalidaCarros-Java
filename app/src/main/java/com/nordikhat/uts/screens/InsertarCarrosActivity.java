package com.nordikhat.uts.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nordikhat.uts.R;
import com.nordikhat.uts.services.insertarVehiculo.InsertVehicleClass;
import com.nordikhat.uts.services.insertarVehiculo.InsertVehiculoClient;
import com.nordikhat.uts.services.insertarVehiculo.MetadaResponse;
import com.nordikhat.uts.services.insertarVehiculo.VehicleResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertarCarrosActivity extends AppCompatActivity {
    private EditText nombre, place, tipo;
    private Button button;

    private InsertVehiculoClient insertVehiculoClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carros);
        getSupportActionBar().setTitle("Insertar Carros");

        //Buscar los edittext en el layout
        nombre = findViewById(R.id.editTextTextPersonName);
        place = findViewById(R.id.editTextTextPersonName2);
        tipo = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.button2);

        insertVehiculoClient = insertVehiculoClient.getInstance();

        button.setOnClickListener(view -> {
            InsertVehicleClass insertVehicleClass = new InsertVehicleClass(nombre.getText().toString(), place.getText().toString(), tipo.getText().toString());
            insertVehiculoClient.getInsertVehicleService().insertVehicle(insertVehicleClass).enqueue(new Callback<VehicleResponse>() {

                @Override
                public void onResponse(@NonNull Call<VehicleResponse> call, Response<VehicleResponse> r) {
                    MetadaResponse[] metada = r.body().getMetadata();
                    String a = metada[0].getData();
                    if (a.equals("Success")){
                        Toast.makeText(InsertarCarrosActivity.this, "Insercion exitosa", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }else{
                        Toast.makeText(InsertarCarrosActivity.this, "Problema insertando", Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public void onFailure(@NonNull Call<VehicleResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "fail:" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}