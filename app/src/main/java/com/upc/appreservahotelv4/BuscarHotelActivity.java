package com.upc.appreservahotelv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.upc.appreservahotelv4.DAO.DAOTipoHabitaciones;
import com.upc.appreservahotelv4.entidades.TipoHabitaciones;

import java.util.ArrayList;
import java.util.List;

public class BuscarHotelActivity extends AppCompatActivity {
    Button btnBuscar;
    Spinner spTipoHabitaciones;
    DAOTipoHabitaciones daoTipoHabitaciones = new DAOTipoHabitaciones(this);
    List<TipoHabitaciones>listaTipoHabitaciones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_hotel);
        asignarReferencias();
        cargarTipoHabitaciones();
        buscarHoteles();
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

    private void buscarHoteles(){
        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(v ->{
            Toast.makeText(this, "Hiciste click en el boton", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this,ListaHabitacionesActivity.class);
            startActivity(intent);
        });
    }
}