package com.upc.appreservahotelv4.entidades;

public class Reservas {
    private int idreserva;
    private String fechaInicio;
    private String fechaFinal;
    private int idHabitacion;
    private int cantidadDias;
    private double precios;

    public Reservas(int idreserva, String fechaInicio, String fechaFinal, int idHabitacion, int cantidadDias, double precios) {
        this.idreserva = idreserva;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idHabitacion = idHabitacion;
        this.cantidadDias = cantidadDias;
        this.precios = precios;
    }

    public Reservas(String fechaInicio, String fechaFinal, int idHabitacion, int cantidadDias, double precios) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idHabitacion = idHabitacion;
        this.cantidadDias = cantidadDias;
        this.precios = precios;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }
}
