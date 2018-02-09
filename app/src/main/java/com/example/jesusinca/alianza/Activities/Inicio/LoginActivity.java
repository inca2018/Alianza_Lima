package com.example.jesusinca.alianza.Activities.Inicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jesusinca.alianza.Entity.Usuario;
import com.example.jesusinca.alianza.R;
import com.example.jesusinca.alianza.Servicios.ServicioLogin;
import com.example.jesusinca.alianza.Utils.DialogosSalidas;

import static com.example.jesusinca.alianza.Entity.Usuario.SESION_ACTUAL;

public class LoginActivity extends AppCompatActivity {
    DialogosSalidas d;
    EditText usuario_login, pass_login;

    ServicioLogin SESION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            usuario_login=findViewById(R.id.login_usuario);
            pass_login=findViewById(R.id.login_pass);
    }

    public void ingresar(View view){
         String usuario=usuario_login.getText().toString().trim();
         String pass=pass_login.getText().toString().trim();

         String mensaje=SESION.Validar_Sesion(usuario,pass);

          if(mensaje.length()==0){
              int codigo=SESION.Recuperar_Codigo_Usuario(usuario,pass);
              Usuario Temp=SESION.Recuperar_Usuario(codigo);
              SESION_ACTUAL.setId(Temp.getId());
              SESION_ACTUAL.setUsuario(Temp.getUsuario());
              SESION_ACTUAL.setNombres(Temp.getNombres());
              SESION_ACTUAL.setApellidos(Temp.getApellidos());
              SESION_ACTUAL.setDni(Temp.getDni());
              SESION_ACTUAL.setArea(Temp.getArea());
              SESION_ACTUAL.setEstado(Temp.getEstado());
              SESION_ACTUAL.setTipo_usuario(Temp.getTipo_usuario());
              SESION_ACTUAL.setCargo(Temp.getCargo());

              Toast.makeText(this, "Ingreso Correctamente", Toast.LENGTH_SHORT).show();
          }else{
              Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
          }
    }

    public void onBackPressed() {
        d.SalidaLogin(getApplicationContext());
        finish();
    }
}
