package com.example.jesusinca.alianza.ActivityEntity;

import com.example.jesusinca.alianza.Utils.Captacion_Vista;

import java.util.List;

/**
 * Created by Jesus Inca on 13/02/2018.
 */

public class modulo_captacion {
    int id_persona;
    String fecha_registro;
    int departamento_id;
    int provincia_id;
    int distrito_id;
    int id_scout;
    int campo_fisico_id;
    int campo_capacidad_id;
    int campo_social_id;
    int campo_tecnico_id;
    int campo_psico_id;
    int sugerido_1;
    int sugerido_2;
    int sugerido_3;
    String lateralidad;
    int estado;
    List<Integer> Resultados_Fisico;
    List<Integer> Resultados_capacidad;
    List<Integer> Resultados_social;
    List<Integer> Resultados_tecnico;
    List<Integer> Resultados_psico;


    public modulo_captacion(){

    }



    public List<Integer> getResultados_Fisico() {
        return Resultados_Fisico;
    }

    public void setResultados_Fisico(List<Integer> resultados_Fisico) {
        Resultados_Fisico = resultados_Fisico;
    }

    public List<Integer> getResultados_capacidad() {
        return Resultados_capacidad;
    }

    public void setResultados_capacidad(List<Integer> resultados_capacidad) {
        Resultados_capacidad = resultados_capacidad;
    }

    public List<Integer> getResultados_social() {
        return Resultados_social;
    }

    public void setResultados_social(List<Integer> resultados_social) {
        Resultados_social = resultados_social;
    }

    public List<Integer> getResultados_tecnico() {
        return Resultados_tecnico;
    }

    public void setResultados_tecnico(List<Integer> resultados_tecnico) {
        Resultados_tecnico = resultados_tecnico;
    }

    public List<Integer> getResultados_psico() {
        return Resultados_psico;
    }

    public void setResultados_psico(List<Integer> resultados_psico) {
        Resultados_psico = resultados_psico;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public int getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(int distrito_id) {
        this.distrito_id = distrito_id;
    }

    public int getId_scout() {
        return id_scout;
    }

    public void setId_scout(int id_scout) {
        this.id_scout = id_scout;
    }

    public int getCampo_fisico_id() {
        return campo_fisico_id;
    }

    public void setCampo_fisico_id(int campo_fisico_id) {
        this.campo_fisico_id = campo_fisico_id;
    }

    public int getCampo_capacidad_id() {
        return campo_capacidad_id;
    }

    public void setCampo_capacidad_id(int campo_capacidad_id) {
        this.campo_capacidad_id = campo_capacidad_id;
    }

    public int getCampo_social_id() {
        return campo_social_id;
    }

    public void setCampo_social_id(int campo_social_id) {
        this.campo_social_id = campo_social_id;
    }

    public int getCampo_tecnico_id() {
        return campo_tecnico_id;
    }

    public void setCampo_tecnico_id(int campo_tecnico_id) {
        this.campo_tecnico_id = campo_tecnico_id;
    }

    public int getCampo_psico_id() {
        return campo_psico_id;
    }

    public void setCampo_psico_id(int campo_psico_id) {
        this.campo_psico_id = campo_psico_id;
    }

    public int getSugerido_1() {
        return sugerido_1;
    }

    public void setSugerido_1(int sugerido_1) {
        this.sugerido_1 = sugerido_1;
    }

    public int getSugerido_2() {
        return sugerido_2;
    }

    public void setSugerido_2(int sugerido_2) {
        this.sugerido_2 = sugerido_2;
    }

    public int getSugerido_3() {
        return sugerido_3;
    }

    public void setSugerido_3(int sugerido_3) {
        this.sugerido_3 = sugerido_3;
    }

    public String getLateralidad() {
        return lateralidad;
    }

    public void setLateralidad(String lateralidad) {
        this.lateralidad = lateralidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
