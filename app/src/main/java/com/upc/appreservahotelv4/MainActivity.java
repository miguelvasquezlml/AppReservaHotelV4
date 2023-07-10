package com.upc.appreservahotelv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarMapas();
        mostrarBusquedaHabitaciones();

    }

    private void mostrarMapas(){
        Button btnMostrarMapas = findViewById(R.id.btnMapas);
        btnMostrarMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapaHotelActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mostrarBusquedaHabitaciones(){
        Button btnMostrarMapas = findViewById(R.id.btnBuscarHab);
        btnMostrarMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BuscarHotelActivity.class);
                startActivity(intent);
            }
        });
    }
}

