package com.upc.appreservahotelv4.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.upc.appreservahotelv4.MainActivity;
import com.upc.appreservahotelv4.entidades.TipoHabitaciones;
import com.upc.appreservahotelv4.util.BaseDatos;

import java.util.ArrayList;
import java.util.List;

public class DAOTipoHabitaciones {
    BaseDatos base;
    SQLiteDatabase db;
    Context context;

    public DAOTipoHabitaciones(Context context) {
        base = new BaseDatos(context);
        this.context = context;
    }

    public void  abrirDB(){
        db= base.getWritableDatabase();
    }

    public List<TipoHabitaciones> cargarTipoHabitaciones(){
        List<TipoHabitaciones> listaTipoHabitaciones= new ArrayList<>();
        try {
            Cursor c= db.rawQuery("SELECT * FROM tipoHabitaciones",null);
            while (c.moveToNext()){
                listaTipoHabitaciones.add(new TipoHabitaciones(c.getInt(0), c.getString(1)));
            }
        }catch (Exception e){
            Log.d("==>",e.getMessage());
        }
        return listaTipoHabitaciones;
    }
}
