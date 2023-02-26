package com.nordikhat.uts.services.insertarVehiculo;

public class VehicleResponse {
    private MetadaResponse[] metadata;
    private VehicleResponseClass vehicleResponse;

    public MetadaResponse[] getMetadata() { return metadata; }
    public void setMetadata(MetadaResponse[] value) { this.metadata = value; }

    public VehicleResponseClass getVehicleResponse() { return vehicleResponse; }
    public void setVehicleResponse(VehicleResponseClass value) { this.vehicleResponse = value; }
}