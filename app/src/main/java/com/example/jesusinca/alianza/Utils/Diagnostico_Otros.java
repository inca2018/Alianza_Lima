package com.example.jesusinca.alianza.Utils;

import com.example.jesusinca.alianza.Entity.Posicion;

/**
 * Created by Jesus Inca on 15/02/2018.
 */

public class Diagnostico_Otros {

    Posicion sugerido1;
    Posicion sugerido2;
    Posicion sugerido3;

    String Nombre_Segurido3;
    String Lateralidad;
    int total_puntaje;

        public static final Diagnostico_Otros OTROS =new  Diagnostico_Otros();

    public Diagnostico_Otros() {
    }

    public Posicion getSugerido1() {
        return sugerido1;
    }

    public void setSugerido1(Posicion sugerido1) {
        this.sugerido1 = sugerido1;
    }

    public Posicion getSugerido2() {
        return sugerido2;
    }

    public void setSugerido2(Posicion sugerido2) {
        this.sugerido2 = sugerido2;
    }

    public Posicion getSugerido3() {
        return sugerido3;
    }

    public void setSugerido3(Posicion sugerido3) {
        this.sugerido3 = sugerido3;
    }

    public String getNombre_Segurido3() {
        return Nombre_Segurido3;
    }

    public void setNombre_Segurido3(String nombre_Segurido3) {
        Nombre_Segurido3 = nombre_Segurido3;
    }

    public String getLateralidad() {
        return Lateralidad;
    }

    public void setLateralidad(String lateralidad) {
        Lateralidad = lateralidad;
    }

    public int getTotal_puntaje() {
        return total_puntaje;
    }

    public void setTotal_puntaje(int total_puntaje) {
        this.total_puntaje = total_puntaje;
    }
}
