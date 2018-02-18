package com.example.jesusinca.alianza.Activities.Captacion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jesusinca.alianza.Adapter.AdapterMasivo;
import com.example.jesusinca.alianza.Adapter.AdapterMasivoPersona;
import com.example.jesusinca.alianza.Entity.Masivo;
import com.example.jesusinca.alianza.Entity.Persona;
import com.example.jesusinca.alianza.Entity.Unidad_Territorial;
import com.example.jesusinca.alianza.Entity.Usuario;
import com.example.jesusinca.alianza.Interface_Alianza.RecyclerViewOnItemClickListener;
import com.example.jesusinca.alianza.Peticiones.RecuperarMasivos;
import com.example.jesusinca.alianza.Peticiones.RecuperarPersonas;
import com.example.jesusinca.alianza.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonaMasivoActivity extends AppCompatActivity {


    private RecyclerView recycler_masivo_postulante;
    private LinearLayoutManager linearLayout;
    private AdapterMasivoPersona adapter;
    private List<Persona> lista_personas;
    Context context;

    CardView nuevo_masivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getApplicationContext();
        setContentView(R.layout.activity_masivo_lista_persona);
        recycler_masivo_postulante=findViewById(R.id.Recylcer_Masivos_postulante);
        nuevo_masivo=findViewById(R.id.nuevo_masivo_postulante);
        lista_personas=new ArrayList<>();

        linearLayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        listar_persona(context);

        adapter = new AdapterMasivoPersona(this, lista_personas, new RecyclerViewOnItemClickListener() {
            public void onClick(View v, int position) {
                //Toast.makeText(context, "CLick id:"+lista_personas.get(position).getId(), Toast.LENGTH_SHORT).show();

            }
        });

        recycler_masivo_postulante.setAdapter(adapter);
        recycler_masivo_postulante.setLayoutManager(linearLayout);


        nuevo_masivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaPersonaMasivoActivity.this, PersonaNuevoMasivoActivity.class);

                ListaPersonaMasivoActivity.this.startActivity(intent);
            }
        });
    }

    private void listar_persona(final Context context) {
        String id_masivo=String.valueOf(Usuario.SESION_ACTUAL.getId_masivo());
        System.out.println("Id_ masivo :"+id_masivo);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONArray masivo=jsonResponse.getJSONArray("masivos_personas");
                        for(int i=0;i<masivo.length();i++){
                            JSONObject objeto= masivo.getJSONObject(i);
                            Persona temp=new Persona();
                            temp.setNombre_Persona(objeto.getString("NOMBRES"));
                            temp.setApellidos_Persona(objeto.getString("APELLIDOS"));
                            temp.setEstado(objeto.getInt("ESTADO"));
                            lista_personas.add(temp);

                        }

                        adapter.notifyDataSetChanged();

                        Toast.makeText(context, "LISTADO EXITOSO", Toast.LENGTH_SHORT).show();
                        System.out.println("LISTADO COMPLETO DE MASIVOS");
                    } else {

                        Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca  : Error de conexion al recuperar departamentos :"+e);
                }
            }
        };
        RecuperarPersonas xx = new RecuperarPersonas(id_masivo,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(xx);
    }


}
