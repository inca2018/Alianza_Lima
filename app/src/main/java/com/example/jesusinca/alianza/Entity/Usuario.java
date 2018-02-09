package com.example.jesusinca.alianza.Entity;

import com.example.jesusinca.alianza.Utils.Captacion_Vista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Inca on 09/02/2018.
 */

public class Usuario {
  int id;
  String usuario;
  String Nombres;
  String Apellidos;
  int dni;
  int tipo_usuario;
  int estado;
  String area;
  String Cargo;


    public static final Usuario SESION_ACTUAL=new Usuario();

    public Usuario(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public static Usuario getSesionActual() {
        return SESION_ACTUAL;
    }
}
