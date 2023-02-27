package com.nordikhat.uts.screens;

public class Vehicle {
    private String nombre;
    private String placa;
    private String tipo;

    public Vehicle(String nombre, String placa, String tipo) {
        this.nombre = nombre;
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
