package com.example.jesusinca.alianza.Activities.Captacion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jesusinca.alianza.Activities.Inicio.LoginActivity;
import com.example.jesusinca.alianza.Activities.Inicio.PrincipalActivity;
import com.example.jesusinca.alianza.Adapter.AdapterMasivo;
import com.example.jesusinca.alianza.Entity.Masivo;
import com.example.jesusinca.alianza.Entity.Unidad_Territorial;
import com.example.jesusinca.alianza.Interface_Alianza.RecyclerViewOnItemClickListener;
import com.example.jesusinca.alianza.Peticiones.RecuperarDepartamentos;
import com.example.jesusinca.alianza.Peticiones.RecuperarMasivos;
import com.example.jesusinca.alianza.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MasivoCreacionActivity extends AppCompatActivity {
    private RecyclerView recycler_masivo;
    private LinearLayoutManager linearLayout;
    private AdapterMasivo adapter;
    private List<Masivo> lista_masivos;
    Context context;

    CardView nuevo_masivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masivo_creacion);
        context=this;
        recycler_masivo=findViewById(R.id.Recylcer_Masivos);
        lista_masivos=new ArrayList<>();
        linearLayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        Listar_Masivos(context);

        adapter = new AdapterMasivo(this, lista_masivos, new RecyclerViewOnItemClickListener() {
            public void onClick(View v, int position) {
                Toast.makeText(context, "CLick id:"+lista_masivos.get(position).getCodigo(), Toast.LENGTH_SHORT).show();

            }
        });

        recycler_masivo.setAdapter(adapter);
        recycler_masivo.setLayoutManager(linearLayout);



        nuevo_masivo=findViewById(R.id.nuevo_masivo);
        nuevo_masivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasivoCreacionActivity.this, NuevoMasivoActivity.class);
                MasivoCreacionActivity.this.startActivity(intent);

            }
        });
    }

    private void Listar_Masivos(final Context context) {

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONArray departamentos=jsonResponse.getJSONArray("masivos");
                        for(int i=0;i<departamentos.length();i++){
                            JSONObject objeto= departamentos.getJSONObject(i);
                            Masivo temp=new Masivo();
                            temp.setCodigo(objeto.getInt("ID"));
                            temp.setNombre_Masivo(objeto.getString("NOMBRE_MASIVO"));
                            Unidad_Territorial Departamento=new Unidad_Territorial();
                            Unidad_Territorial Provincia=new Unidad_Territorial();
                            Unidad_Territorial Distrito=new Unidad_Territorial();
                            Departamento.setCodigo(objeto.getInt("DEPARTAMENTO_ID"));
                            Departamento.setDescripcion(objeto.getString("DEPARTAMENTO_NOM"));
                            Provincia.setCodigo(objeto.getInt("PROVINCIA_ID"));
                            Provincia.setDescripcion(objeto.getString("PROVINCIA_NOM"));
                            Distrito.setCodigo(objeto.getInt("DISTRITO_ID"));
                            Distrito.setDescripcion(objeto.getString("DISTRITO_NOM"));
                            temp.setDepartamento(Departamento);
                            temp.setProvincia(Provincia);
                            temp.setDistrito(Distrito);

                            temp.setFecha_Creacion(objeto.getString("FECHA_CREACION"));
                            temp.setId_Usuario(objeto.getInt("SCOUT_ID"));
                            temp.setUsuario_Creador(objeto.getString("CREADO_NOM"));
                            temp.setEstado(objeto.getInt("ESTADO"));
                            temp.setTotal_postulantes(objeto.getInt("TOTAL"));

                            lista_masivos.add(temp);

                            adapter.notifyDataSetChanged();
                        }

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

        RecuperarMasivos xx = new RecuperarMasivos(responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(xx);


    }
}
