package com.nordikhat.uts.login;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class LoginClient {
    private static LoginClient instance;
    private LoginService loginService;

    public static LoginClient getInstance() {
        if (instance == null) {
            instance = new LoginClient();
        }
        return instance;
    }

    public LoginClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("NICOLAS BASE URL")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loginService = retrofit.create(LoginService.class);
    }

    public LoginService getLoginService() {
        return loginService;
    }
}
