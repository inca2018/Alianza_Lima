package com.example.jesusinca.alianza.Server;

import com.example.jesusinca.alianza.Entity.Persona;
import com.example.jesusinca.alianza.Entity.Usuario;
import com.example.jesusinca.alianza.Servicios.ServicioLogin;

/**
 * Created by Jesus Inca on 09/02/2018.
 */

public class ServerLogin implements ServicioLogin {
    @Override
    public String Validar_Sesion(String usuario, String pass) {





        return null;
    }

    @Override
    public int Recuperar_Codigo_Usuario(String usuario, String pass) {





        return 0;
    }

    @Override
    public Usuario Recuperar_Usuario(int codigo_usuario) {






        return null;
    }
}
