package com.upc.appreservahotelv4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.upc.appreservahotelv4.DAO.DAOTipoHabitaciones;
import com.upc.appreservahotelv4.entidades.TipoHabitaciones;

import java.util.ArrayList;
import java.util.List;

public class BuscarHotelActivity extends AppCompatActivity {

    Spinner spTipoHabitaciones;
    DAOTipoHabitaciones daoTipoHabitaciones = new DAOTipoHabitaciones(this);
    List<TipoHabitaciones>listaTipoHabitaciones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_hotel);
        asignarReferencias();
        cargarTipoHabitaciones();
    }

    private void asignarReferencias(){
        spTipoHabitaciones=findViewById(R.id.spTipoHabitacion);
    }
    private void cargarTipoHabitaciones(){
        daoTipoHabitaciones.abrirDB();
        listaTipoHabitaciones= daoTipoHabitaciones.cargarTipoHabitaciones();
        ArrayAdapter<TipoHabitaciones> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaTipoHabitaciones);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoHabitaciones.setAdapter(adaptador);
    }
}