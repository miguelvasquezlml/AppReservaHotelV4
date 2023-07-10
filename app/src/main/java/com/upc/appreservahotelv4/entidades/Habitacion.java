package com.upc.appreservahotelv4.entidades;

public class Habitacion {
    private int idHabitacion;
    private String descrpcion;
    private int idHotal;
    private int idTipoHabitaciones;
    private Double precio;
    private String destino;
    private int distponible;

    public Habitacion(int idHabitacion, String descrpcion, int idHotal, int idTipoHabitaciones, Double precio, String destino, int distponible) {
        this.idHabitacion = idHabitacion;
        this.descrpcion = descrpcion;
        this.idHotal = idHotal;
        this.idTipoHabitaciones = idTipoHabitaciones;
        this.precio = precio;
        this.destino = destino;
        this.distponible = distponible;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public int getIdHotal() {
        return idHotal;
    }

    public void setIdHotal(int idHotal) {
        this.idHotal = idHotal;
    }

    public int getIdTipoHabitaciones() {
        return idTipoHabitaciones;
    }

    public void setIdTipoHabitaciones(int idTipoHabitaciones) {
        this.idTipoHabitaciones = idTipoHabitaciones;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistponible() {
        return distponible;
    }

    public void setDistponible(int distponible) {
        this.distponible = distponible;
    }
}
