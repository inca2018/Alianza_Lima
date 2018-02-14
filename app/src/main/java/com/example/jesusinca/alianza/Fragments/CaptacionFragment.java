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
    GestionUbigeo captacion;
    public CaptacionFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        captacion=new GestionUbigeo();
        //setHasOptionsMenu(true);
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

         Verificacion_UbigeoCaptacion();

         accion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(captacion.isEstado()==true){
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

                if(captacion.isEstado()==true){
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
                if(captacion.isEstado()==true){
                    Toast.makeText(mContext, "ACTUALIZACION", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mContext, "NUEVO FECHA", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
    private void Verificacion_UbigeoCaptacion() {
               int codigo_captacion=1;
               int codigo_usuario=SESION_ACTUAL.getId();
               Validar_Ubicacion(codigo_captacion,codigo_usuario,mContext);
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
                        String ubigeo_general=jsonResponse.getString("ubigeo_general");
                        switch (id_modulo){
                            case 1:
                                boolean estado=jsonResponse.getBoolean("estado");
                                if(estado==true){
                                    SpannableString mitextoU = new SpannableString(ubigeo_general);
                                    mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
                                    texto_ubigeo_Capta.setText(mitextoU);
                                    imagen_ubigeo_Capta.setImageResource(R.mipmap.icon_update);
                                    captacion.setEstado(true);
                                }else{
                                    SpannableString mitextoU = new SpannableString(ubigeo_general);
                                    mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
                                    texto_ubigeo_Capta.setText(mitextoU);
                                    imagen_ubigeo_Capta.setImageResource(R.mipmap.icon_next);
                                    captacion.setEstado(false);
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
                    System.out.println("Inca  : Error en Recupera codigo de usuario :"+e);
                }
            }
        };

        Validar_Ubigeo recuperarCodigo = new Validar_Ubigeo(user, modulo, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(recuperarCodigo);
    }

}
