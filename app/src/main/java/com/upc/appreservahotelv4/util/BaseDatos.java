package com.upc.appreservahotelv4.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context){
        super(context,"hoteles.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE tipoHabitaciones("+
                "idTipoHabitaciones INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "tipoHabitaciones TEXT NOT NULL)";
        db.execSQL(query);

        query ="INSERT INTO tipoHabitaciones VALUES(NULL,'SUIT');";
        query ="INSERT INTO tipoHabitaciones VALUES(NULL,'MATRIMONIAL');";
        query ="INSERT INTO tipoHabitaciones VALUES(NULL,'DOBLES');";
        query ="INSERT INTO tipoHabitaciones VALUES(NULL,'PERSONAL');";

        db.execSQL(query);

///////////////////////////////////////////////////////////////////////////////////////////////////
        query ="CREATE TABLE login("+
                "idLogin INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "idusuario INTEGER,"+
                "correo TEXT NOT NULL,"+
                "clave TEXT NOT NULL)";
        db.execSQL(query);

        query ="INSERT INTO login VALUES(NULL,'1','immiguelvasquez@gmail.com','123456');";
        query ="INSERT INTO login VALUES(NULL,'2','droman8427@gmail.co','123456');";
        query ="INSERT INTO login VALUES(NULL,'3','ravila2271@gmail.com','123456');";

        db.execSQL(query);
///////////////////////////////////////////////////////////////////////////////////////////////////
        query ="CREATE TABLE usuario("+
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "apellido TEXT NOT NULL)";

        db.execSQL(query);

        query ="INSERT INTO usuario VALUES(NULL,'MIGUEL','VASQUEZ');";
        query ="INSERT INTO usuario VALUES(NULL,'DANIEL','ROMAN');";
        query ="INSERT INTO usuario VALUES(NULL,'ROBERTO','AVILA');";

        db.execSQL(query);

///////////////////////////////////////////////////////////////////////////////////////////////////

        query ="CREATE TABLE hotel("+
                "idHotel INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "descripcion TEXT NOT NULL,"+
                "latitud TEXT NOT NULL,"+
                "longitud TEXT NOT NULL,"+
                "direccion TEXT NOT NULL)";

        db.execSQL(query);

        query ="INSERT INTO hotel VALUES(NULL,'Hotel Monasterio San Pedro','-13.519384430837409','-71.98409123795426',' Cascaparo 116, Cusco 08002');";
        query ="INSERT INTO hotel VALUES(NULL,'Mint Hotel','-13.51504486681824','-71.96907086736691','C-12 Urbanizacion, San Isidro, Arequipa');";

        db.execSQL(query);
///////////////////////////////////////////////////////////////////////////////////////////////////

        query ="CREATE TABLE habitacion("+
                "idHabitacion INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "descripcion TEXT NOT NULL,"+
                "idHotal INTEGER,"+
                "idTipoHabitaciones INTEGER,"+
                "precio DOUBLE NOT NULL,"+
                "disponible INTEGER NOT NULL)";

        db.execSQL(query);

        query ="INSERT INTO habitacion VALUES(NULL,'Habitacion 1','1','1',1000,1);";
        query ="INSERT INTO habitacion VALUES(NULL,'Habitacion 2','2','2',1000,1);";
        query ="INSERT INTO habitacion VALUES(NULL,'Habitacion 3','2','3',1000,1);";

        db.execSQL(query);
///////////////////////////////////////////////////////////////////////////////////////////////////
        query ="CREATE TABLE reservas("+
                "idreserva INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "fechaInicio TEXT NOT NULL,"+
                "fechaFinal TEXT NOT NULL,"+
                "idHabitacion INTEGER,"+
                "cantidadDias INTEGER NOT NULL,"+
                "precios DOUBLE NOT NULL)";

       /* db.execSQL(query);

        query ="INSERT INTO habitacion VALUES(NULL,'MIGUEL','VASQUEZ');";
        query ="INSERT INTO habitacion VALUES(NULL,'DANIEL','ROMAN');";
        query ="INSERT INTO habitacion VALUES(NULL,'ROBERTO','AVILA');";*/

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
