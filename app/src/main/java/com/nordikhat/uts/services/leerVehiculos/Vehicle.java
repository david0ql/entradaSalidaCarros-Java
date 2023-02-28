package com.nordikhat.uts.services.leerVehiculos;

public class Vehicle {
    private String checkIn;
    private String name;
    private String plate;
    private Long id;
    private Long state;
    private String type;

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String value) { this.checkIn = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getPlate() { return plate; }
    public void setPlate(String value) { this.plate = value; }

    public Long getID() { return id; }
    public void setID(Long value) { this.id = value; }

    public Long getState() { return state; }
    public void setState(Long value) { this.state = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
}