package com.example.jesusinca.alianza.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.jesusinca.alianza.Activities.Captacion.CaptacionActivity;
import com.example.jesusinca.alianza.Activities.Ubigeo.UbigeoActivity;
import com.example.jesusinca.alianza.Entity.Unidad_Territorial;
import com.example.jesusinca.alianza.Peticiones.RecuperarCodigoUsuario;
import com.example.jesusinca.alianza.Peticiones.Validar_Ubigeo;
import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Utils.GestionUbigeo;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.jesusinca.alianza.Entity.Usuario.SESION_ACTUAL;

public class CaptacionFragment extends Fragment {
    public Context mContext;
    Button accion1,accion2,accion3,accion4,accion5,accion6;
    TextView texto_ubigeo_Capta;
    ImageView imagen_ubigeo_Capta;

    public CaptacionFragment() {
        // Required empty public constructor
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        //setHasOptionsMenu(true);
        Verificacion_UbigeoCaptacion();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_captacion, container, false);

        accion1=(Button)v.findViewById(R.id.accion_1);
        texto_ubigeo_Capta=v.findViewById(R.id.texto_ubigeo);
        imagen_ubigeo_Capta=v.findViewById(R.id.icon_ubigeo);

        accion2=(Button)v.findViewById(R.id.accion_2);
        accion3=(Button)v.findViewById(R.id.accion_3);
        accion4=(Button)v.findViewById(R.id.accion_4);
        accion5=(Button)v.findViewById(R.id.accion_5);
        accion6=(Button)v.findViewById(R.id.accion_6);


         accion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(GestionUbigeo.CAPTACION_UBIGEO.isEstado()==true){
                    Intent intent= new Intent(mContext,CaptacionActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(mContext, "Seleccione Ubicación de Trabajo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        accion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(GestionUbigeo.CAPTACION_UBIGEO.isEstado()==true){
                    Intent intent= new Intent(mContext,CaptacionActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(mContext, "Seleccione Ubicación de Trabajo", Toast.LENGTH_SHORT).show();
                }

            }
        });

        imagen_ubigeo_Capta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(GestionUbigeo.CAPTACION_UBIGEO.isEstado()==true){
                    Intent intent= new Intent(mContext,UbigeoActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(mContext, "NUEVO Ubigeo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
    private void Verificacion_UbigeoCaptacion() {
               int codigo_captacion=1;
               GestionUbigeo.CAPTACION_UBIGEO.setCodigo_modulo(codigo_captacion);
               int codigo_usuario=SESION_ACTUAL.getId();
               System.out.println("CODIGO_USER:"+codigo_usuario);
               Validar_Ubicacion(codigo_captacion,codigo_usuario,mContext);
               System.out.println("PASO VERIFICACION INCA");
    }

    public void Validar_Ubicacion(final int id_user,final int id_modulo, final Context context) {
        String user = String.valueOf(id_user).trim();
        String modulo=String.valueOf(id_modulo).trim();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {

                        System.out.println("PASO SUCCESS");
                        String ubigeo_general=jsonResponse.getString("ubigeo_general");
                        switch (id_modulo){
                            case 1:
                                boolean estado=jsonResponse.getBoolean("estado");
                                if(estado==true){
                                    SpannableString mitextoU = new SpannableString("UBICACION:"+ubigeo_general);
                                    mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
                                    texto_ubigeo_Capta.setText(mitextoU);
                                    imagen_ubigeo_Capta.setImageResource(R.mipmap.icon_update);
                                    GestionUbigeo.CAPTACION_UBIGEO.setEstado(true);

                                    Unidad_Territorial Departamento=new Unidad_Territorial();
                                    Departamento.setCodigo(jsonResponse.getInt("id_depa"));
                                    Departamento.setDescripcion(jsonResponse.getString("desc_depa"));
                                    Unidad_Territorial Provincia=new Unidad_Territorial();
                                    Provincia.setCodigo(jsonResponse.getInt("id_prov"));
                                    Provincia.setDescripcion(jsonResponse.getString("desc_prov"));
                                    Unidad_Territorial Distrito=new Unidad_Territorial();
                                    Distrito.setCodigo(jsonResponse.getInt("id_dist"));
                                    Distrito.setDescripcion(jsonResponse.getString("desc_dist"));

                                    GestionUbigeo.CAPTACION_UBIGEO.setDepartamento(Departamento);
                                    GestionUbigeo.CAPTACION_UBIGEO.setProvincia(Provincia);
                                    GestionUbigeo.CAPTACION_UBIGEO.setDistrito(Distrito);
                                    GestionUbigeo.CAPTACION_UBIGEO.setUbigeo_descripcion(ubigeo_general);

                                    System.out.println("PASO TRUE ESTADO");
                                }else{
                                    SpannableString mitextoU = new SpannableString("SELECCIONE UBICACION DE TRABAJO");
                                    mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
                                    texto_ubigeo_Capta.setText(mitextoU);
                                    imagen_ubigeo_Capta.setImageResource(R.mipmap.icon_next);
                                    GestionUbigeo.CAPTACION_UBIGEO.setEstado(false);

                                    System.out.println("PASO FALSE ESTADO");
                                }

                                break;
                            case 2:

                                break;

                                default:
                                    Toast.makeText(context, "No existe id de modulo!!", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        String error = jsonResponse.getString("error");
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca  : Error en Recupera ubigeo user:"+e);
                }
            }
        };

        Validar_Ubigeo recuperarCodigo = new Validar_Ubigeo(user, modulo, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(recuperarCodigo);
    }

}
