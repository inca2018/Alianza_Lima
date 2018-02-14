package com.example.jesusinca.alianza.Activities.Ubigeo;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jesusinca.alianza.Entity.Unidad_Territorial;
import com.example.jesusinca.alianza.Peticiones.RecuperarCodigoUsuario;
import com.example.jesusinca.alianza.Peticiones.RecuperarDepartamentos;
import com.example.jesusinca.alianza.Peticiones.RecuperarDistritos;
import com.example.jesusinca.alianza.Peticiones.RecuperarProvincias;
import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Utils.Conexion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UbigeoActivity extends AppCompatActivity {

    Spinner departamento,provincias,distritos;
    List<Unidad_Territorial> DepartamentosLista,ProvinciasLista,DistritoLista;
    String[] spinner_departamentos,spinner_provincias,spinner_distritos;
    Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubigeo);
        DepartamentosLista=new ArrayList<>();
        ProvinciasLista=new ArrayList<>();
        DistritoLista=new ArrayList<>();
        mcontext=this;

        departamento=(Spinner)findViewById(R.id.spinner_departamento);
        provincias=(Spinner)findViewById(R.id.spinner_provincia);
        distritos=(Spinner)findViewById(R.id.spinner_distrito);

        Listar_Departamentos(mcontext);

        departamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                int id_departamento_seleccionado=0;
                System.out.println("Valor Spinner Depa:"+String.valueOf(item));
                System.out.println("posicion Spinner Depa:"+String.valueOf(i+1));
                System.out.println("Valor Departamento Lista:"+String.valueOf(DepartamentosLista.get(i).getDescripcion()));
                System.out.println("ID Departamento Lista:"+String.valueOf(DepartamentosLista.get(i).getCodigo()));

                for(int x=0;x<DepartamentosLista.size();x++){
                    if(DepartamentosLista.get(x).getDescripcion().equalsIgnoreCase(String.valueOf(item))){
                        id_departamento_seleccionado=DepartamentosLista.get(x).getCodigo();
                    }
                }

                ProvinciasLista.clear();
                DistritoLista.clear();
                Listar_Provincias(id_departamento_seleccionado,mcontext);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        provincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                int id_provincia_seleccionado=0;

                System.out.println("Valor Spinner Prov:"+String.valueOf(item));
                System.out.println("posicion Spinner prov:"+String.valueOf(i+1));
                System.out.println("Valor Provi Lista :"+String.valueOf(ProvinciasLista.get(i).getDescripcion()));
                System.out.println("ID provi Lista:"+String.valueOf(ProvinciasLista.get(i).getCodigo()));
                for(int x=0;x<ProvinciasLista.size();x++){
                    if(ProvinciasLista.get(x).getDescripcion().equalsIgnoreCase(String.valueOf(item))){
                        id_provincia_seleccionado=ProvinciasLista.get(x).getCodigo();
                    }
                }
                DistritoLista.clear();
                Listar_Distritos(id_provincia_seleccionado,mcontext);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void Listar_Departamentos(final Context context){

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                         JSONArray departamentos=jsonResponse.getJSONArray("departamento");
                          for(int i=0;i<departamentos.length();i++){
                               JSONObject objeto= departamentos.getJSONObject(i);
                               Unidad_Territorial temp=new Unidad_Territorial();
                                      temp.setCodigo(objeto.getInt("idDepa"));
                                      temp.setDescripcion(objeto.getString("departamento"));
                              DepartamentosLista.add(temp);
                              System.out.println("id_Depa="+temp.getCodigo()+"  Descripcion_depa="+temp.getDescripcion());
                          }


                          spinner_departamentos=new String[DepartamentosLista.size()];
                          for(int i=0;i<DepartamentosLista.size();i++){
                              spinner_departamentos[i]=DepartamentosLista.get(i).getDescripcion();
                          }
                          ArrayAdapter<String> adapter_arr=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item,spinner_departamentos);
                        departamento.setAdapter(adapter_arr);


                    } else {

                        Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca  : Error de conexion al recuperar departamentos :"+e);
                }
            }
        };

        RecuperarDepartamentos recuperarDepa = new RecuperarDepartamentos(responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(recuperarDepa);

    }
    private void Listar_Provincias(final int id_departamento,final Context context){
       String id_depa=String.valueOf(id_departamento);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONArray provinciass=jsonResponse.getJSONArray("provincia");
                        for(int i=0;i<provinciass.length();i++){
                            JSONObject objeto= provinciass.getJSONObject(i);
                            Unidad_Territorial temp=new Unidad_Territorial();
                            temp.setCodigo(objeto.getInt("idProv"));
                            temp.setDescripcion(objeto.getString("provincia"));
                            ProvinciasLista.add(temp);
                        }
                        spinner_provincias=new String[ProvinciasLista.size()];
                        for(int i=0;i<ProvinciasLista.size();i++){
                            spinner_provincias[i]=ProvinciasLista.get(i).getDescripcion();
                        }
                        ArrayAdapter<String> adapter_arr=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item,spinner_provincias);
                        provincias.setAdapter(adapter_arr);


                    } else {

                        Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca  : Error de conexion al recuperar departamentos :"+e);
                }
            }
        };

        RecuperarProvincias recuperarProv = new RecuperarProvincias(id_depa,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(recuperarProv);
    }
    private void Listar_Distritos(final int id_provincia,final Context context) {
        String id_prov=String.valueOf(id_provincia);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONArray distritoss=jsonResponse.getJSONArray("distrito");
                        for(int i=0;i<distritoss.length();i++){
                            JSONObject objeto= distritoss.getJSONObject(i);
                            Unidad_Territorial temp=new Unidad_Territorial();
                            temp.setCodigo(objeto.getInt("idDist"));
                            temp.setDescripcion(objeto.getString("distrito"));
                            DistritoLista.add(temp);
                        }
                        spinner_distritos=new String[DistritoLista.size()];
                        for(int i=0;i<DistritoLista.size();i++){
                            spinner_distritos[i]=DistritoLista.get(i).getDescripcion();
                        }
                        ArrayAdapter<String> adapter_arr=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item,spinner_distritos);
                        distritos.setAdapter(adapter_arr);


                    } else {

                        Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca  : Error de conexion al recuperar departamentos :"+e);
                }
            }
        };

        RecuperarDistritos recuperarDist = new RecuperarDistritos(id_prov,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(recuperarDist);

    }

}
