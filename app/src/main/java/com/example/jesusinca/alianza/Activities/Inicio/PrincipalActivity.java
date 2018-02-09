package com.example.jesusinca.alianza.Activities.Inicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jesusinca.alianza.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        Toast.makeText(this, "Ingreso a menu principal", Toast.LENGTH_SHORT).show();

    }
}
