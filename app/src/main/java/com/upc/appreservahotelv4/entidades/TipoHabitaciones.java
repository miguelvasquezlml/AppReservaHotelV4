package com.upc.appreservahotelv4.entidades;

public class TipoHabitaciones {

    private int idTipoHabitaciones;
    private String tipoHabitaciones;

    public TipoHabitaciones(int idTipoHabitaciones, String tipoHabitaciones) {
        this.idTipoHabitaciones = idTipoHabitaciones;
        this.tipoHabitaciones = tipoHabitaciones;
    }

    public int getIdTipoHabitaciones() {
        return idTipoHabitaciones;
    }

    public void setIdTipoHabitaciones(int idTipoHabitaciones) {
        this.idTipoHabitaciones = idTipoHabitaciones;
    }

    public String getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    public void setTipoHabitaciones(String tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }
}
