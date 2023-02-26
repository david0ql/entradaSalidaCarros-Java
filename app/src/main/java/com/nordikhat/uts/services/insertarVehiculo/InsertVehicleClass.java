package com.nordikhat.uts.services.insertarVehiculo;


public class InsertVehicleClass {
    private String name;
    private String plate;
    private String type;

    public InsertVehicleClass(String name, String plate, String type) {
        this.name = name;
        this.plate = plate;
        this.type = type;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getPlate() { return plate; }
    public void setPlate(String value) { this.plate = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
}
