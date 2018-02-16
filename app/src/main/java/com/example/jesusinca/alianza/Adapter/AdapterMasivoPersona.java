package com.example.jesusinca.alianza.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        public TextView ubigeo_masivo;
        public TextView creador_masivo;
        public TextView total_masivo;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titulo_masivo=itemView.findViewById(R.id.card_masivo_titulo);
            ubigeo_masivo=itemView.findViewById(R.id.card_masivo_ubigeo);
            creador_masivo=itemView.findViewById(R.id.card_masivo_creador);
            total_masivo=itemView.findViewById(R.id.card_masivo_cantidad_postulantes);
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
    public void onBindViewHolder(ViewHolder holder, final int position) {



    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }
}