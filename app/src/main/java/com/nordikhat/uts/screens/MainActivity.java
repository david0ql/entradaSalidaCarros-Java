package com.nordikhat.uts.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nordikhat.uts.R;
import com.nordikhat.uts.services.login.LoginClass;
import com.nordikhat.uts.services.login.LoginClient;
import com.nordikhat.uts.services.login.LoginResponse;
import com.nordikhat.uts.services.login.Metadatum;

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
            try {
                loginClient.getLoginService().login(loginClass).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<LoginResponse> call, Response<LoginResponse> r) {
                        Metadatum datum =  r.body().getMetadata()[0];
                        String tipo = datum.getType();
                        if (tipo.equals("ok")){
                            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                            i.putExtra("name", r.body().getName().toString());
                            startActivity(i);
                        }else {
                            Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "fail:" + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }catch (Exception e){
                Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
            }

        });


    }
}