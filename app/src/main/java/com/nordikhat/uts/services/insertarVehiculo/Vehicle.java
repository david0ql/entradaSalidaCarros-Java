package com.nordikhat.uts.services.insertarVehiculo;

public class Vehicle {
    private long id;
    private String name;
    private String plate;
    private String type;
    private String checkIn;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getPlate() { return plate; }
    public void setPlate(String value) { this.plate = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String value) { this.checkIn = value; }
}
