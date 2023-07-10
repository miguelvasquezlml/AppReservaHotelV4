package com.upc.appreservahotelv4.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.upc.appreservahotelv4.entidades.Habitacion;
import com.upc.appreservahotelv4.entidades.TipoHabitaciones;
import com.upc.appreservahotelv4.util.BaseDatos;

import java.util.ArrayList;
import java.util.List;

public class DAOHabitaciones {
    BaseDatos base;
    SQLiteDatabase db;
    Context context;

    public DAOHabitaciones(Context context){
        base = new BaseDatos(context);
        this.context = context;
    }
    public void  abrirDB(){
        db= base.getWritableDatabase();
    }

    public List<Habitacion> cargarHabitaciones(){
        List<Habitacion> listaHabitacion= new ArrayList<>();
        try {
            Cursor c= db.rawQuery("SELECT * FROM habitacion",null);
            while (c.moveToNext()){
                listaHabitacion.add(new Habitacion(
                        c.getInt(0),
                        c.getString(1),
                        c.getInt(2),
                        c.getInt(3),
                        c.getDouble(4),
                        c.getString(5),
                        c.getInt(6)
                ));
            }
        }catch (Exception e){
            Log.d("==>",e.getMessage());
        }
        return listaHabitacion;
    }
}
