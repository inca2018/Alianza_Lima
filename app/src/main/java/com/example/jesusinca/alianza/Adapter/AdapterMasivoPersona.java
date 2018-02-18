package com.example.jesusinca.alianza.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesusinca.alianza.Entity.Masivo;
import com.example.jesusinca.alianza.Entity.Persona;
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


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titulo_masivo=itemView.findViewById(R.id.card_masivo_titulo);
            acciones=itemView.findViewById(R.id.masivo_personas_acciones);
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
            holder.acciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final PopupMenu popupMenu=new PopupMenu(context,holder.acciones);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_item_masivo,popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            if(item.getTitle().toString().equalsIgnoreCase("Evaluar")){
                                Toast.makeText(context, "OPCION1", Toast.LENGTH_SHORT).show();
                            }else if(item.getTitle().toString().equalsIgnoreCase("Resultados")){
                                Toast.makeText(context, "OPCION2", Toast.LENGTH_SHORT).show();
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