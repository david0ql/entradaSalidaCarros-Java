package com.nordikhat.uts.services.leerVehiculos;

public class VehicleResponse {
    private Metadatum[] metadata;
    private VehicleResponseClass vehicleResponse;

    public Metadatum[] getMetadata() { return metadata; }
    public void setMetadata(Metadatum[] value) { this.metadata = value; }

    public VehicleResponseClass getVehicleResponse() { return vehicleResponse; }
    public void setVehicleResponse(VehicleResponseClass value) { this.vehicleResponse = value; }
}