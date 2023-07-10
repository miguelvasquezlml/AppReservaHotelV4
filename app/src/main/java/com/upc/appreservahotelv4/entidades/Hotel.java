package com.upc.appreservahotelv4.entidades;

public class Hotel {
    private int idHotal;
    private String descrpcion;
    private String latitud;
    private String longitud;
    private String destino;
    private String direccion;

    public Hotel(int idHotal, String descrpcion, String latitud, String longitud, String destino, String direccion) {
        this.idHotal = idHotal;
        this.descrpcion = descrpcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.destino = destino;
        this.direccion = direccion;
    }

    public int getIdHotal() {
        return idHotal;
    }

    public void setIdHotal(int idHotal) {
        this.idHotal = idHotal;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
