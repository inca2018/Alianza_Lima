package com.example.jesusinca.alianza.Activities.Captacion;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jesusinca.alianza.Entity.Persona;
import com.example.jesusinca.alianza.Entity.Unidad_Territorial;
import com.example.jesusinca.alianza.Fragments_Resultados.Tab1;
import com.example.jesusinca.alianza.Fragments_Resultados.Tab2;
import com.example.jesusinca.alianza.Fragments_Resultados.Tab3;
import com.example.jesusinca.alianza.Fragments_Resultados.Tab4;
import com.example.jesusinca.alianza.Fragments_Resultados.Tab5;
import com.example.jesusinca.alianza.Fragments_Resultados.Tab6;
import com.example.jesusinca.alianza.Peticiones.RecuperarDistritos;
import com.example.jesusinca.alianza.Peticiones.RecuperarResultadosDiagnostico;
import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Utils.ResultadosDiagnostico;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MasivoResultadosActivity extends AppCompatActivity{
    TabLayout tabLayout;
    ViewPager viewPager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_masivo_resultados);
        tabLayout=(TabLayout)findViewById(R.id.TabLayout);
        viewPager=findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);
        SetupViewPager(viewPager);

    }

    public void SetupViewPager(ViewPager viewPager){
        MyViewPageAdapter myViewPageAdapter=new MyViewPageAdapter(getSupportFragmentManager());
        myViewPageAdapter.AddPageFragment(new Tab1(),"Generales");
        myViewPageAdapter.AddPageFragment(new Tab2(),"Fisico");
        myViewPageAdapter.AddPageFragment(new Tab3(),"Capacidad");
        myViewPageAdapter.AddPageFragment(new Tab4(),"Social");
        myViewPageAdapter.AddPageFragment(new Tab5(),"Tecnico");
        myViewPageAdapter.AddPageFragment(new Tab6(),"Psicologico");

        viewPager.setAdapter(myViewPageAdapter);
    }

    public class MyViewPageAdapter extends FragmentPagerAdapter{
       private List<Fragment> myFragment= new ArrayList<Fragment>();
       private List<String>   myTitle= new ArrayList<>();

       public MyViewPageAdapter(FragmentManager manager){
           super(manager);

       }

       public void  AddPageFragment(Fragment Frag,String title){
            myFragment.add(Frag);
            myTitle.add(title);
       }


       @Override
       public CharSequence getPageTitle(int position){
           return myTitle.get(position);
       }

        @Override
        public Fragment getItem(int position) {
            return myFragment.get(position);
        }

        @Override
        public int getCount() {
            return 6;
        }
    }

}
