package com.example.jesusinca.alianza.Fragments_Resultados;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Utils.Recurso_Resultados;
import com.example.jesusinca.alianza.Utils.Recursos_Diagnostico;
import com.example.jesusinca.alianza.Utils.ResultadosDiagnostico;

public class Tab2 extends Fragment {

    public Tab2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_tab2, container, false);

        setear_Texto(v);



        return v;
    }

    private void setear_Texto(View v) {

     for(int i=0;i< Recurso_Resultados.OPCION_FISICO.size();i++){
         TextView temp=v.findViewById(Recurso_Resultados.OPCION_FISICO.get(i).getText_Pregunta());
         temp.setText(i+".- "+Recurso_Resultados.OPCION_FISICO.get(i).getPregunta());

         TextView temp_resp=v.findViewById(Recurso_Resultados.OPCION_FISICO.get(i).getText_Resultado());
          String resu=ResultadosDiagnostico.RESULTADO_TEMP.getFISICO().get(i).toString();
         temp_resp.setText(resu+" Ptos.");
     }


    }


}
