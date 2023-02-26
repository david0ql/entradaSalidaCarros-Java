package com.nordikhat.uts.services.insertarVehiculo;

import com.nordikhat.uts.api.ApiClass;
import com.nordikhat.uts.services.login.LoginClient;
import com.nordikhat.uts.services.login.LoginService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class InsertVehiculoClient {
    private static InsertVehiculoClient instance;
    private InsertVehiculoService vehicleService;

    public static InsertVehiculoClient getInstance() {
        if (instance == null) {
            instance = new InsertVehiculoClient();
        }
        return instance;
    }

    public InsertVehiculoClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClass.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vehicleService = retrofit.create(InsertVehiculoService.class);
    }

    public InsertVehiculoService getInsertVehicleService() {
        return vehicleService;
    }
}
