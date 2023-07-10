package com.upc.appreservahotelv4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.appreservahotelv4.entidades.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class AdapatadorPersonalizador extends RecyclerView.Adapter<AdapatadorPersonalizador.MyViewHolder>
{
    private Context context;
    private List<Habitacion> listaHabitación = new ArrayList<>();
    public AdapatadorPersonalizador(Context context,List<Habitacion> listaHabitacion){
        this.context=context;
        this.listaHabitación=listaHabitacion;
    }

    @NonNull
    @Override
    public AdapatadorPersonalizador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista=inflater.inflate(R.layout.fila,parent,false);
        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapatadorPersonalizador.MyViewHolder holder, int position) {
        holder.filaHabitacion.setText(listaHabitación.get(position).getDescrpcion()+"");
        holder.filaPrecio.setText(listaHabitación.get(position).getPrecio()+"");
        holder.filaDestino.setText(listaHabitación.get(position).getDestino()+"");
        holder.filaEstado.setText(listaHabitación.get(position).getDistponible()+"");
    }

    @Override
    public int getItemCount() {
        return listaHabitación.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView filaHotel,filaHabitacion,filaTipHab,filaPrecio,filaDestino,filaEstado;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            filaHotel=itemView.findViewById(R.id.filaHotel);
            filaHabitacion=itemView.findViewById(R.id.filaHabitacion);
            filaTipHab=itemView.findViewById(R.id.filaTipHab);
            filaPrecio=itemView.findViewById(R.id.filaPrecio);
            filaDestino=itemView.findViewById(R.id.filaDestino);
            filaEstado=itemView.findViewById(R.id.filaEstado);
        }
    }
}
