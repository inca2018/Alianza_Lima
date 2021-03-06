package com.example.jesusinca.alianza.Peticiones;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.jesusinca.alianza.Utils.Conexion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus Inca on 14/02/2018.
 */

public class RecuperarPosiciones extends StringRequest {

    private static final String LOGIN_REQUEST_URL = Conexion.RUTA_SERVICIO_CAPTACION;
    private Map<String, String> params;

    public RecuperarPosiciones(Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("operacion","recuperar_posiciones");


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
