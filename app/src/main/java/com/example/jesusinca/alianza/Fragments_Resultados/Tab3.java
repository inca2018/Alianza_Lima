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
import com.example.jesusinca.alianza.Utils.ResultadosDiagnostico;


public class Tab3 extends Fragment {


    public Tab3() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_tab3, container, false);


        setear_Texto(v);



        return v;
    }

    private void setear_Texto(View v) {
        for(int i = 0; i< Recurso_Resultados.OPCION_CAPACIDAD.size(); i++){
            TextView temp=v.findViewById(Recurso_Resultados.OPCION_CAPACIDAD.get(i).getText_Pregunta());
            int pos=i+1;
            temp.setText(pos+".- "+Recurso_Resultados.OPCION_CAPACIDAD.get(i).getPregunta());

            TextView temp_resp=v.findViewById(Recurso_Resultados.OPCION_CAPACIDAD.get(i).getText_Resultado());
            String resu= ResultadosDiagnostico.RESULTADO_TEMP.getCAPACIDAD().get(i).toString();
            temp_resp.setText(resu+" Ptos.");
        }


    }


}
