package com.nordikhat.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nordikhat.uts.login.LoginClass;
import com.nordikhat.uts.login.LoginClient;

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
            loginClient.getLoginService().login(loginClass).enqueue(new Callback<LoginClass>() {
                @Override
                public void onResponse(Call<LoginClass> call, Response<LoginClass> r) {
                    Toast.makeText(getApplicationContext(), "ok " + r.body() + " created", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<LoginClass> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "fail:" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });


    }
}