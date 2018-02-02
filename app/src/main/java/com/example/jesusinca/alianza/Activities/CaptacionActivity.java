package com.example.jesusinca.alianza.Activities;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Utils.Captacion_Vista;
import com.example.jesusinca.alianza.Utils.Captacion_funcional;
import com.example.jesusinca.alianza.Utils.Recursos;

import java.util.ArrayList;
import java.util.List;

public class CaptacionActivity extends AppCompatActivity {
    CardView card;
    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captacion);
        card=findViewById(R.id.card_totalizado);
        scroll=findViewById(R.id.scroll_captacion);


        // Animaciones de Vistas Captacion
        for(int i=0;i<Recursos.LISTA_VISTAS.size();i++){

            LinearLayout linear=findViewById(Recursos.LISTA_VISTAS.get(i).getContenedor());
            LayoutInflater inflater = LayoutInflater.from(this);

            final View view_actual = inflater.inflate(Recursos.LISTA_VISTAS.get(i).getVista(), linear, true);
            LinearLayout line=view_actual.findViewById(Recursos.LISTA_VISTAS.get(i).getArea_Accion());

            Recursos.LISTA_VISTAS.get(i).setView(line);

            LinearLayout Accion_Panel=findViewById(Recursos.LISTA_VISTAS.get(i).getPanel_Accion());

            Generar_Animacion(Recursos.LISTA_VISTAS.get(i),line,Accion_Panel);
        }

        //Seleccion de Opciones group checked!
        for(int i=0;i<Recursos.LISTA_FISICO.size();i++){
            Generar_Funcion(i,Recursos.LISTA_FISICO.get(i));
        }
        for(int i=0;i<Recursos.LISTA_CAPACIDAD.size();i++){
            Generar_Funcion(i,Recursos.LISTA_CAPACIDAD.get(i));
        }
        for(int i=0;i<Recursos.LISTA_SOCIAL.size();i++){
            Generar_Funcion(i,Recursos.LISTA_SOCIAL.get(i));
        }
        for(int i=0;i<Recursos.LISTA_PSICO.size();i++){
            Generar_Funcion(i,Recursos.LISTA_PSICO.get(i));
        }
        for(int i=0;i<Recursos.LISTA_TECNICO.size();i++){
            Generar_Funcion(i,Recursos.LISTA_TECNICO.get(i));
        }

    }

    private void Generar_Funcion(int v, final Captacion_funcional captacion_funcional) {
        int n=v+1;
        TextView textView=findViewById(captacion_funcional.getTextView());
        textView.setText(n+".- "+captacion_funcional.getOpcion());

        RadioGroup grupo=findViewById(captacion_funcional.getGroupRadio());
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== captacion_funcional.getRadio1()){
                    captacion_funcional.setResultado(0);
                    Refrescar_Totales();
                }else if(i == captacion_funcional.getRadio2()){
                    captacion_funcional.setResultado(1);
                    Refrescar_Totales();
                }
                else if(i == captacion_funcional.getRadio3()){
                    captacion_funcional.setResultado(2);
                    Refrescar_Totales();
                }else if(i == captacion_funcional.getRadio4()){
                    captacion_funcional.setResultado(3);
                    Refrescar_Totales();
                }
            }
        });

    }

    private void Refrescar_Totales() {
        int total1=0;
        int total2=0;
        int total3=0;
        int total4=0;
        int total5=0;

        int total_general=0;

        for(int i=0;i<Recursos.LISTA_FISICO.size();i++){
            total1=total1+Recursos.LISTA_FISICO.get(i).getResultado();
        }
        TextView fisico_total=findViewById(Recursos.LISTA_VISTAS.get(0).getTextViewTotal());
        fisico_total.setText(total1+" Ptos.");
        for(int i=0;i<Recursos.LISTA_CAPACIDAD.size();i++){
            total2=total2+Recursos.LISTA_CAPACIDAD.get(i).getResultado();
        }

        TextView capacidad_total=findViewById(Recursos.LISTA_VISTAS.get(1).getTextViewTotal());
        capacidad_total.setText(total2+" Ptos.");
        for(int i=0;i<Recursos.LISTA_SOCIAL.size();i++){
            total3=total3+Recursos.LISTA_SOCIAL.get(i).getResultado();
        }
        TextView social_total=findViewById(Recursos.LISTA_VISTAS.get(2).getTextViewTotal());
        social_total.setText(total3+" Ptos.");
        for(int i=0;i<Recursos.LISTA_TECNICO.size();i++){
            total4=total4+Recursos.LISTA_TECNICO.get(i).getResultado();
        }
        TextView tecnico_total=findViewById(Recursos.LISTA_VISTAS.get(3).getTextViewTotal());
        tecnico_total.setText(total4+" Ptos.");
        for(int i=0;i<Recursos.LISTA_PSICO.size();i++){
            total5=total5+Recursos.LISTA_PSICO.get(i).getResultado();
        }
        TextView psico_total=findViewById(Recursos.LISTA_VISTAS.get(4).getTextViewTotal());
        psico_total.setText(total5+" Ptos.");

        TextView total_g=findViewById(R.id.total_captacion);
        total_general=total1+total2+total3+total4+total5;
        total_g.setText(total_general+" Ptos.");

        if(total_general>=45 && total_general<=49){
            card.setCardBackgroundColor(getResources().getColor(R.color.Orange));
        }else if(total_general>=50){
            card.setCardBackgroundColor(getResources().getColor(R.color.green));
        }else if(total_general<=44){
            card.setCardBackgroundColor(getResources().getColor(R.color.grey));
        }
    }

    private void Generar_Animacion(final Captacion_Vista captacion_vista,final LinearLayout view_actual,LinearLayout Accion_Panel ) {

        Accion_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(captacion_vista.getAccion()==0){
                    scroll.smoothScrollTo(0,0);
                    view_actual.setVisibility(View.VISIBLE);

                    captacion_vista.setAccion(1);
                    Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abajo);
                    view_actual.startAnimation(animation);

                    cerrar_ventanas(view_actual);
                }else if(captacion_vista.getAccion()==1){
                    scroll.smoothScrollTo(0,0);
                    captacion_vista.setAccion(0);
                    Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.arriba);
                    view_actual.startAnimation(animation);
                    view_actual.setVisibility(View.GONE);
                }

            }
        });
    }

    private void cerrar_ventanas(LinearLayout view_actual) {
        for(int i=0;i<Recursos.LISTA_VISTAS.size();i++){
            if(Recursos.LISTA_VISTAS.get(i).getView()==view_actual){

            }else{
               Recursos.LISTA_VISTAS.get(i).getView().setVisibility(View.GONE);
            }
        }
    }


}
