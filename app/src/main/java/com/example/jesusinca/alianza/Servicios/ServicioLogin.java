package com.example.jesusinca.alianza.Servicios;

import com.example.jesusinca.alianza.Entity.Persona;
import com.example.jesusinca.alianza.Entity.Usuario;

/**
 * Created by Jesus Inca on 09/02/2018.
 */

public interface ServicioLogin {

    String Validar_Sesion(String usuario,String pass);
    int Recuperar_Codigo_Usuario(String usuario,String pass);
    Usuario Recuperar_Usuario(int codigo_usuario);


}
