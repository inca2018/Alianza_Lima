package com.example.jesusinca.alianza.Activities.Captacion;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Utils.Recursos_Registro_Postulante;
import java.util.Calendar;

public class RegistroPostulantesActivity extends AppCompatActivity {
    public ImageButton btn1;
    public TextView f_naci;
    Calendar dateTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_postulantes);
        f_naci=findViewById(R.id.capta_fecha_nacimiento);
        btn1=findViewById(R.id.d_fecha_nacimiento);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });
        Recuperar_Variables();
    }
    private void Recuperar_Variables() {
               for(int i=0;i<Recursos_Registro_Postulante.LISTA_REGISTRO.size();i++){
                    EditText temp=findViewById(Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).getRecurso());
                    Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).setCampoEditText(temp);
               }
    }
    private void updateDate(){
        new DatePickerDialog(this, d1,1999,0,1).show();
    }
    private void updateTextLabel1(){
        int mes =dateTime.get(Calendar.MONTH)+1;
        String fecha_nacimiento=dateTime.get(Calendar.DAY_OF_MONTH)+"/"+mes+"/"+dateTime.get(Calendar.YEAR);
        f_naci.setText(fecha_nacimiento);


        for(int i=0;i<Recursos_Registro_Postulante.LISTA_REGISTRO.size();i++){
            if(Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).getId()==7){
                Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).setValor(fecha_nacimiento);
            }
        }
    }
    public void guardar_deportista (View view) {
        Boolean estado;
        estado=Verificar_Vacios();

        if(estado==true){
            Toast.makeText(this, "Registro Correctamente", Toast.LENGTH_SHORT).show();
        }else{
            String mensaje=Armar_Mensaje();
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        }

    }
    private String Armar_Mensaje() {
        String temp="";

        for(int i=0;i<Recursos_Registro_Postulante.LISTA_REGISTRO.size();i++){
            if(Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).isEstado()==false){
                temp=temp+Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).getMensaje_Vacio()+"\n";
            }
        }


        return temp;
    }
    private Boolean Verificar_Vacios() {
       Boolean t=true;

        for(int i=0;i<Recursos_Registro_Postulante.LISTA_REGISTRO.size();i++){
            String texto_temp=Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).getCampoEditText().getText().toString();
            Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).setValor(texto_temp);
            if(texto_temp.length()!=0){
                Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).setEstado(true);
            }else if(texto_temp.length()==0){
                Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).setEstado(false);
            }
        }

        for(int i=0;i<Recursos_Registro_Postulante.LISTA_REGISTRO.size();i++){
            if(Recursos_Registro_Postulante.LISTA_REGISTRO.get(i).isEstado()==false){
                t=false;
            }
        }

     return t;
    }
    DatePickerDialog.OnDateSetListener d1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, monthOfYear);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateTextLabel1();
        }
    };
}
