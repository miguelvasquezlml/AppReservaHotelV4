package com.upc.appreservahotelv4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.upc.appreservahotelv4.DAO.DAOTipoHabitaciones;
import com.upc.appreservahotelv4.entidades.TipoHabitaciones;

public class MainActivity extends AppCompatActivity {
    TipoHabitaciones tipoHabitaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DAOTipoHabitaciones daoTipoHabitaciones= new DAOTipoHabitaciones(this);
        daoTipoHabitaciones.abrirDB();
    }
}