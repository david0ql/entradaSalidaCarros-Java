package com.nordikhat.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nordikhat.uts.login.LoginClass;
import com.nordikhat.uts.login.LoginClient;
import com.nordikhat.uts.login.LoginResponse;
import com.nordikhat.uts.login.MetadataResponse;

import java.io.IOException;

import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button button;
    private LoginClient loginClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscar los componentes en el Layout
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        //Realizar peticion
        loginClient = loginClient.getInstance();

        button.setOnClickListener(view -> {
            LoginClass loginClass = new LoginClass(username.getText().toString(), password.getText().toString());
            loginClient.getLoginService().login(loginClass).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, Response<LoginResponse> r) {
                    assert r.body() != null;
                    MetadataResponse[] metada = r.body().getMetadata();
                    String tipo = metada[0].getTipo();
                    if (tipo.equals("ok")){
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }else {
                        Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "fail:" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });


    }
}