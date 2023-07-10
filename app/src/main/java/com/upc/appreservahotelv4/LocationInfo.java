package com.upc.appreservahotelv4;

public class LocationInfo {
    private double latitud;
    private double longitud;
    private String titulo;
    private String precio;
    private int cantidad;
    private String fechaInicio;
    private String fechaFin;



    public LocationInfo(double latitud, double longitud, String titulo, String precio,int cantidad,String fechaInicio,String fechaFin) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
