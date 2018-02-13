package com.example.jesusinca.alianza.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jesusinca.alianza.Activities.Captacion.CaptacionActivity;
import com.example.jesusinca.alianza.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaptacionFragment extends Fragment {
    public Context mContext;
    Button accion1,accion2,accion3,accion4,accion5,accion6;

    public CaptacionFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        //setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_captacion, container, false);
        accion1=(Button)v.findViewById(R.id.accion_1);
        accion2=(Button)v.findViewById(R.id.accion_2);
        accion3=(Button)v.findViewById(R.id.accion_3);
        accion4=(Button)v.findViewById(R.id.accion_4);
        accion5=(Button)v.findViewById(R.id.accion_5);
        accion6=(Button)v.findViewById(R.id.accion_6);

         accion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mContext,CaptacionActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}
