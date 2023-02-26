package com.nordikhat.uts.services.insertarVehiculo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InsertVehiculoService {
    @POST("/insertVehicle")
    Call<VehicleResponse> insertVehicle(@Body InsertVehicleClass insertVehicle);
}
