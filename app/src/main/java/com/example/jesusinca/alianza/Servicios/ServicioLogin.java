package com.example.jesusinca.alianza.Servicios;

import android.content.Context;

import com.example.jesusinca.alianza.Entity.Usuario;

public interface ServicioLogin {

    String Validar_Sesion(String usuario, String pass, Context context);
    int Recuperar_Codigo_Usuario(String usuario,String pass,Context context);
    Usuario Recuperar_Usuario(int codigo_usuario,Context context);


}
