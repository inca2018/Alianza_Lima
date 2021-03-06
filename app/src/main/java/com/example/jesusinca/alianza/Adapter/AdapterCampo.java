package com.example.jesusinca.alianza.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jesusinca.alianza.Entity.Campo;
import com.example.jesusinca.alianza.Interface_Alianza.RecyclerViewOnItemClickListener;
import com.example.jesusinca.alianza.R;
import java.util.List;

public class AdapterCampo extends RecyclerView.Adapter<AdapterCampo.ViewHolder> {
    private Context context;
    private List<Campo> my_Data;

    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    int Puntostotal=0;
    AlertDialog da;

    public AdapterCampo(Context context, List<Campo> my_Data, RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button btn;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
                  btn=itemView.findViewById(R.id.card_campos_boton);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
    public AdapterCampo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_campo,parent,false);
        return new AdapterCampo.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(AdapterCampo.ViewHolder holder, final int position) {

        holder.btn.getLayoutParams().height=my_Data.get(position).getAltura();
       // holder.btn.getLayoutParams().width=my_Data.get(position).getAncho();
        holder.btn.setHeight(my_Data.get(position).getAltura());
        //holder.btn.setWidth(my_Data.get(position).getAncho());
        //holder.btn.setBackground(context.getResources().getDrawable(my_Data.get(position).getDrawable()));

         holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                final View dialoglayout4 = inflater.inflate(R.layout.gestion_campo, null);
                final TextView fab1= dialoglayout4.findViewById(R.id.op1);
                final TextView fab2= dialoglayout4.findViewById(R.id.op2);
                final TextView fab3= dialoglayout4.findViewById(R.id.op3);
                final TextView fab4= dialoglayout4.findViewById(R.id.op4);
                final TextView fab5= dialoglayout4.findViewById(R.id.op5);

                final AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                da=builder4.show();

                fab1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("P");
                        my_Data.get(position).setCant(-1);
                        Puntostotal=Puntostotal-1;
                        notifyDataSetChanged();
                        da.dismiss();

                    }
                });
                fab2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("R");
                        my_Data.get(position).setCant(1);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });

                fab3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("PG");
                        my_Data.get(position).setCant(1);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
                fab4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("DR");
                        my_Data.get(position).setCant(1);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
                fab5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("G");
                        my_Data.get(position).setCant(3);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
