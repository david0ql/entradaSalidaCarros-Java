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
import com.nordikhat.uts.services.login.MetadataResponse;

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
                    MetadataResponse[] metada = r.body().getMetadata();
                    Gson gson = new Gson();
                    System.out.println(gson.toJson(metada));
//                    if (tipo.equals("ok")){
//                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                    }else {
//                        Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
//                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "fail:" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });


    }
}