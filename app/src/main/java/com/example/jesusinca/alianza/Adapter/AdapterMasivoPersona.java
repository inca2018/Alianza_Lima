package com.example.jesusinca.alianza.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesusinca.alianza.Activities.Captacion.CaptacionActivity;
import com.example.jesusinca.alianza.Activities.Captacion.ListaMasivosActivity;
import com.example.jesusinca.alianza.Activities.Captacion.MasivoNuevoActivity;
import com.example.jesusinca.alianza.Activities.Captacion.MasivoResultadosActivity;
import com.example.jesusinca.alianza.Entity.Masivo;
import com.example.jesusinca.alianza.Entity.Persona;
import com.example.jesusinca.alianza.Entity.Usuario;
import com.example.jesusinca.alianza.Interface_Alianza.RecyclerViewOnItemClickListener;
import com.example.jesusinca.alianza.R;

import java.util.List;


/**
 * Created by Jesus on 23/12/2016.
 */
public class AdapterMasivoPersona extends RecyclerView.Adapter<AdapterMasivoPersona.ViewHolder>{
    public Context context;
    private List<Persona> my_Data;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public AdapterMasivoPersona(Context context, List<Persona> my_Data, RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView titulo_masivo;
        public ImageView acciones;
        public TextView texto_disponible;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titulo_masivo=itemView.findViewById(R.id.card_masivo_titulo);
            acciones=itemView.findViewById(R.id.masivo_personas_acciones);
            texto_disponible=itemView.findViewById(R.id.texto_disponibilidad);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_masivo_persona,parent,false);
        return new ViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

            holder.titulo_masivo.setText(my_Data.get(position).getNombre_Persona()+" "+my_Data.get(position).getApellidos_Persona());
            int disponibilidad=my_Data.get(position).getDisponible();
            if(disponibilidad==1){
                holder.texto_disponible.setText("DISPONIBLE");
                holder.texto_disponible.setTextColor(context.getResources().getColor(R.color.verde));
            }else if(disponibilidad==2){
                holder.texto_disponible.setText("NO DISPONIBLE");
                holder.texto_disponible.setTextColor(context.getResources().getColor(R.color.red));
            }
            holder.acciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final PopupMenu popupMenu=new PopupMenu(context,holder.acciones);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_item_masivo,popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            if(item.getTitle().toString().equalsIgnoreCase("Evaluar")){
                                int estado=my_Data.get(position).getEstado_capta();
                                int disponibilidad=my_Data.get(position).getDisponible();
                                if(disponibilidad==1){
                                    if(estado==1){
                                        Toast.makeText(context, "Postulante ya tiene una Evaluaciòn Realizada!", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Persona.PERSONA_TEMP.setId(my_Data.get(position).getId());
                                        Persona.PERSONA_TEMP.setNombre_Persona(my_Data.get(position).getNombre_Persona());
                                        Persona.PERSONA_TEMP.setApellidos_Persona(my_Data.get(position).getApellidos_Persona());

                                        Intent intent = new Intent(context, CaptacionActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        context.startActivity(intent);

                                    }

                                }else{
                                    Toast.makeText(context, "Potulante no Disponible", Toast.LENGTH_SHORT).show();
                                }

                            }else if(item.getTitle().toString().equalsIgnoreCase("Resultados")){
                                int estado=my_Data.get(position).getEstado_capta();
                                if(estado==1){
                                     Intent intent=new Intent(context, MasivoResultadosActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                     context.startActivity(intent);
                                }else if(estado==2){
                                    Toast.makeText(context, "Postulante no tiene Evaluaciòn Disponible", Toast.LENGTH_SHORT).show();
                                }
                            }else if(item.getTitle().toString().equalsIgnoreCase("Eliminar")){
                                Toast.makeText(context, "OPCION3", Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        }
                    });

                    popupMenu.show();
                }
            });

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }
}