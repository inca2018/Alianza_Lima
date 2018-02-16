package com.example.jesusinca.alianza.Activities.Captacion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jesusinca.alianza.Adapter.AdapterMasivo;
import com.example.jesusinca.alianza.Adapter.AdapterMasivoPersona;
import com.example.jesusinca.alianza.Entity.Masivo;
import com.example.jesusinca.alianza.Entity.Persona;
import com.example.jesusinca.alianza.R;

import java.util.List;

public class MasivoListaPersonaActivity extends AppCompatActivity {


    private RecyclerView recycler_masivo_postulante;
    private LinearLayoutManager linearLayout;
    private AdapterMasivoPersona adapter;
    private List<Persona> lista_personas;
    Context context;

    CardView nuevo_masivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masivo_lista_persona);
    }
}
