package com.nordikhat.uts.services.insertarVehiculo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InsertVehiculoService {
    @POST("/v1/insertVehicle")
    Call<VehicleResponse> insertVehicle(@Body InsertVehicleClass insertVehicle);
}
