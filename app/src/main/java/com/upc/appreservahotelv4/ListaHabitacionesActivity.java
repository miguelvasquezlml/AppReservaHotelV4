package com.upc.appreservahotelv4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upc.appreservahotelv4.DAO.DAOHabitaciones;
import com.upc.appreservahotelv4.entidades.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class ListaHabitacionesActivity extends AppCompatActivity {
    RecyclerView rvHabitacion;
    //FloatingActionButton btnAgregar;
    DAOHabitaciones daoHabitaciones = new DAOHabitaciones(this);
    List<Habitacion> listaHabitaciones= new ArrayList<>();
    AdapatadorPersonalizador adapatador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_habitaciones);
        asignarReferencias();
        cargarHabitaciones();
    }
    private void asignarReferencias()
    {
        //btnAgregar=findViewById(R.id.btnAgregar);
        //btnAgregar.setOnClickListener(v -> );
        rvHabitacion=findViewById(R.id.rvHabitacion);
    }
    private void cargarHabitaciones(){
        daoHabitaciones.abrirDB();
        listaHabitaciones= daoHabitaciones.cargarHabitaciones();
        AdapatadorPersonalizador adaptador = new AdapatadorPersonalizador(this,listaHabitaciones);
        rvHabitacion.setAdapter(adaptador);
        rvHabitacion.setLayoutManager(new LinearLayoutManager(this));
    }
}