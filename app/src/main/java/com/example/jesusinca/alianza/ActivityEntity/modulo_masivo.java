package com.example.jesusinca.alianza.ActivityEntity;

import com.example.jesusinca.alianza.Entity.Masivo;
import com.example.jesusinca.alianza.Entity.Unidad_Territorial;

import java.util.List;

/**
 * Created by Jesus Inca on 16/02/2018.
 */

public class modulo_masivo {
   List<Masivo> Lista_masivos;



   public modulo_masivo(){

   }

    public List<Masivo> getLista_masivos() {
        return Lista_masivos;
    }

    public void setLista_masivos(List<Masivo> lista_masivos) {
        Lista_masivos = lista_masivos;
    }
}
