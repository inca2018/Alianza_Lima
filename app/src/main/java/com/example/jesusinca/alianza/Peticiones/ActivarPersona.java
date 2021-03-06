package com.example.jesusinca.alianza.Peticiones;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.jesusinca.alianza.Utils.Conexion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus Inca on 09/02/2018.
 */

public class ActivarPersona extends StringRequest {

    private static final String LOGIN_REQUEST_URL = Conexion.RUTA_SERVICIO_CAPTACION;
    private Map<String, String> params;

    public ActivarPersona(String id_persona, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("operacion","Activar_Persona");
        params.put("id_persona",id_persona);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
