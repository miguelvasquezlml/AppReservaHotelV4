package com.upc.appreservahotelv4;

public class LocationInfo {
    private double latitud;
    private double longitud;
    private String titulo;
    private String nombre;

    public LocationInfo(double latitud, double longitud, String titulo, String nombre) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.titulo = titulo;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }
}
