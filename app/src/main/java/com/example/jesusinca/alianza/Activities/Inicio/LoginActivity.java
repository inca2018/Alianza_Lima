package com.example.jesusinca.alianza.Activities.Inicio;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    ProgressDialog progressDialog;
    //Variable de servicio
    ServicioLogin Servicio_login;
    Button ingresar;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            context=getApplicationContext();
            usuario_login=findViewById(R.id.login_usuario);
            pass_login=findViewById(R.id.login_pass);
            ingresar=findViewById(R.id.ingresar_login);

            ingresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Ingresar_Sesion();

                }
            });
    }

    public void Ingresar_Sesion(){
         System.out.println("Ingreso click INCA");
        //Recuperar variables de sesion
         String usuario=usuario_login.getText().toString().trim();
         String pass=pass_login.getText().toString().trim();


         //Inicio de progress de carga
         progressDialog = new ProgressDialog(this);
         progressDialog.setTitle("Login");
         progressDialog.setMessage("Verificando Usuario...");
         progressDialog.show();

        //Recuperar mensaje de validacion , Vacio= Ingreso , LLeno = Mensaje de error (usuario no existe, password incorrecto)
         String mensaje=Servicio_login.Validar_Sesion(usuario,pass,progressDialog,context);

         if(mensaje==null){
             System.out.println("Ingreso mensaje null INCA");
         }else{
             System.out.println("Ingreso mensaje con datos INCA "+mensaje);
         }

         //Condicion si existe mensaje de error , si no procede con la sesion
          if(mensaje.length()==0){
              //Recupera codigo del usuario validado
              int codigo=Servicio_login.Recuperar_Codigo_Usuario(usuario,pass,context);
              //Recupera datos del usuario con el codigo

              if(codigo==0){
                  Toast.makeText(this, "Problema de Conexión al Recuperar Usuario", Toast.LENGTH_SHORT).show();
              }else{

              Usuario Temp=Servicio_login.Recuperar_Usuario(codigo,context);
                if(Temp==null){
                    Toast.makeText(this, "Problemas de Conexión al Recuperar Datos del Usuario", Toast.LENGTH_SHORT).show();
                }else{
                SESION_ACTUAL.setId(Temp.getId());
                SESION_ACTUAL.setUsuario(Temp.getUsuario());
                SESION_ACTUAL.setNombres(Temp.getNombres());
                SESION_ACTUAL.setApellidos(Temp.getApellidos());
                SESION_ACTUAL.setDni(Temp.getDni());
                SESION_ACTUAL.setArea(Temp.getArea());
                SESION_ACTUAL.setEstado(Temp.getEstado());
                SESION_ACTUAL.setTipo_usuario(Temp.getTipo_usuario());
                SESION_ACTUAL.setCargo(Temp.getCargo());
                SESION_ACTUAL.setFoto(Temp.getFoto());
                SESION_ACTUAL.setPassword(Temp.getPassword());
                SESION_ACTUAL.setCorreo(Temp.getCorreo());
                SESION_ACTUAL.setFecha_creacion(Temp.getFecha_creacion());
                SESION_ACTUAL.setFecha_conexion(Temp.getFecha_conexion());
                //Cierra progress
                progressDialog.dismiss();
                //Cambia de activity al validar correctamente la sesion
                Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                LoginActivity.this.startActivity(intent);
                //Muestra mensaje
                Toast.makeText(this, "Ingreso Correctamente", Toast.LENGTH_SHORT).show();
                }
              }
          }else{
              //Muestra Mensaje de error
              limpiar();
              Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
          }
    }
  // Salir de Login , salir del sistema
    public void onBackPressed() {
        d.SalidaLogin(getApplicationContext());
        finish();
    }

    public void limpiar(){
        usuario_login.setText("");
        pass_login.setText("");
    }
}
