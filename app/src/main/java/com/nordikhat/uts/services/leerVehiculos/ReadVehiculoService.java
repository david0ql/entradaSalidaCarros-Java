package com.nordikhat.uts.services.leerVehiculos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReadVehiculoService {
    @GET("/v1/listAllVehicles")
    Call<VehicleResponse> readVehicles();
}

