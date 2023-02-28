package com.nordikhat.uts.services.leerVehiculos;

public class Vehicle {
    private String checkIn;
    private String name;
    private String plate;
    private long id;
    private long state;
    private String type;

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getPlate() { return plate; }
    public void setPlate(String value) { this.plate = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public long getState() { return state; }
    public void setState(long value) { this.state = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
}