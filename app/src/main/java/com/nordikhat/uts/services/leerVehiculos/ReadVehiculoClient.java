package com.nordikhat.uts.services.leerVehiculos;

import com.nordikhat.uts.api.ApiClass;
import com.nordikhat.uts.services.insertarVehiculo.InsertVehiculoClient;
import com.nordikhat.uts.services.insertarVehiculo.InsertVehiculoService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReadVehiculoClient {
    private static ReadVehiculoClient instance;
    private ReadVehiculoService vehicleService;

    public static ReadVehiculoClient getInstance() {
        if (instance == null) {
            instance = new ReadVehiculoClient();
        }
        return instance;
    }

    public ReadVehiculoClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClass.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vehicleService = retrofit.create(ReadVehiculoService.class);
    }

    public ReadVehiculoService getReadVehicleService() {
        return vehicleService;
    }
}
