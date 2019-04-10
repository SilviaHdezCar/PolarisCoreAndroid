package com.example.wposs_user.polariscoreandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTerminal extends RecyclerView.Adapter<AdapterTerminal.ViewHolderTerminal> {

    ArrayList<Terminal> ter ;


    public AdapterTerminal(ArrayList<Terminal> ter)
    {
        this.ter = ter;
    }


    @Override
    public ViewHolderTerminal onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panel_terminal,null,false);

        return new ViewHolderTerminal(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderTerminal holderDatos, int i) {
        holderDatos.asignarTerminal(ter.get(i));

    }

    @Override
    public int getItemCount() {
        return ter.size();
    }

    public class ViewHolderTerminal extends RecyclerView.ViewHolder {

        TextView serial;
        TextView marca;
        TextView modelo;
        TextView tecnologia;
        TextView estado;
        TextView fechaLim;
        TextView tit;


        public ViewHolderTerminal(View v) {
            super(v);
            tit = (TextView)v.findViewById(R.id.titulo_terr);
            serial = (TextView) v.findViewById(R.id.serial_ter);
           marca = (TextView) v.findViewById(R.id.marca_ter);
           modelo = (TextView) v.findViewById(R.id.modelo_ter);
           tecnologia = (TextView) v.findViewById(R.id.tecno_ter);
           estado = (TextView) v.findViewById(R.id.estado_ter);
           fechaLim=(TextView) v.findViewById(R.id.fechal_ter);


        }

        public void asignarTerminal(Terminal term) {

            int i = 0;


            for (Terminal t : ter) {


               serial.setText(t.getSerial());
                marca.setText(t.getEstado());
                modelo.setText(t.getModelo());
                tecnologia.setText(t.getTecnologia());
                estado.setText(t.getEstado());
                fechaLim.setText(t.getFechaLimite());


                if(t.getSerial().equals(serial.getText().toString())) {
                    int x = ter.indexOf(t)+1;
                    tit.setText("-----------------------------------TERMINAL " + x+"-----------------------------------");
                }

            }
        }
    }


}
