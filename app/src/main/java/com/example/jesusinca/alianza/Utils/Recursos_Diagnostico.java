package com.example.jesusinca.alianza.Utils;

import com.example.jesusinca.alianza.Activities.Captacion.RegistroPostulantesActivity;
import com.example.jesusinca.alianza.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Inca on 24/01/2018.
 */

public class Recursos_Diagnostico {

    public static final List<Captacion_Vista> LISTA_VISTAS= new ArrayList<>();
    public  static final List<Captacion_funcional> LISTA_FISICO =new ArrayList<>();
    public static final List<Captacion_funcional> LISTA_CAPACIDAD =new ArrayList<>();
    public static final List<Captacion_funcional> LISTA_SOCIAL =new ArrayList<>();
    public static final List<Captacion_funcional> LISTA_TECNICO =new ArrayList<>();
    public static final List<Captacion_funcional> LISTA_PSICO =new ArrayList<>();

    static{

        LISTA_VISTAS.add(new Captacion_Vista(R.layout.area_fisico,R.id.contenedor_fisico,R.id.panel_fisico,R.id.area_fisico,0,R.id.total_fisico));
        LISTA_VISTAS.add(new Captacion_Vista(R.layout.area_capacidad,R.id.contenedor_capacidad,R.id.panel_capacidad,R.id.area_capacidad,0,R.id.total_capacidad));
        LISTA_VISTAS.add(new Captacion_Vista(R.layout.area_social,R.id.contenedor_social,R.id.panel_social,R.id.area_social,0,R.id.total_social));
        LISTA_VISTAS.add(new Captacion_Vista(R.layout.area_tecnico,R.id.contenedor_tecnico,R.id.panel_tecnico,R.id.area_tecnico,0,R.id.total_tecnico));
        LISTA_VISTAS.add(new Captacion_Vista(R.layout.area_psico,R.id.contenedor_psico,R.id.panel_psico,R.id.area_psico,0,R.id.total_psico));


        LISTA_FISICO.add(new Captacion_funcional("Estatura según Posición",R.id.opcion_fisico1,
                             R.id.group_fisico1,
                             R.id.f11,
                             R.id.f12,
                             R.id.f13,
                             R.id.f14,0));
        LISTA_FISICO.add(new Captacion_funcional("Peso según Posición",R.id.opcion_fisico2,
                R.id.group_fisico2,
                R.id.f21,
                R.id.f22,
                R.id.f23,
                R.id.f24,0));
        LISTA_FISICO.add(new Captacion_funcional("Técnica de Carrera",R.id.opcion_fisico3,
                R.id.group_fisico3,
                R.id.f31,
                R.id.f32,
                R.id.f33,
                R.id.f34,0));
        LISTA_FISICO.add(new Captacion_funcional("Posición del Talón",R.id.opcion_fisico4,
                R.id.group_fisico4,
                R.id.f41,
                R.id.f42,
                R.id.f43,
                R.id.f44,0));
        LISTA_FISICO.add(new Captacion_funcional("Aceleración",R.id.opcion_fisico5,
                R.id.group_fisico5,
                R.id.f51,
                R.id.f52,
                R.id.f53,
                R.id.f54,0));

        LISTA_FISICO.add(new Captacion_funcional("Potencia",R.id.opcion_fisico6,
                R.id.group_fisico6,
                R.id.f61,
                R.id.f62,
                R.id.f63,
                R.id.f64,0));
        LISTA_FISICO.add(new Captacion_funcional("Resistencia",R.id.opcion_fisico7,
                R.id.group_fisico7,
                R.id.f71,
                R.id.f72,
                R.id.f73,
                R.id.f74,0));

        LISTA_CAPACIDAD.add(new Captacion_funcional("Percepción e Interpretación",R.id.opcion_capacidad1,
                R.id.group_capacidad1,
                R.id.c11,
                R.id.c12,
                R.id.c13,
                R.id.c14,0));
        LISTA_CAPACIDAD.add(new Captacion_funcional("Toma de Decisiones",R.id.opcion_capacidad2,
                R.id.group_capacidad2,
                R.id.c21,
                R.id.c22,
                R.id.c23,
                R.id.c24,0));
        LISTA_CAPACIDAD.add(new Captacion_funcional("Inteligencia Táctica y Posicionamiento",R.id.opcion_capacidad3,
                R.id.group_capacidad3,
                R.id.c31,
                R.id.c32,
                R.id.c33,
                R.id.c34,0));

        LISTA_CAPACIDAD.add(new Captacion_funcional("Visión de juego",R.id.opcion_capacidad4,
                R.id.group_capacidad4,
                R.id.c41,
                R.id.c42,
                R.id.c43,
                R.id.c44,0));

        LISTA_SOCIAL.add(new Captacion_funcional("Actitud ante el Adversario",R.id.opcion_social1,
                R.id.group_social1,
                R.id.s11,
                R.id.s12,
                R.id.s13,
                R.id.s14,0));

        LISTA_SOCIAL.add(new Captacion_funcional("Actitud con Compañeros",R.id.opcion_social2,
                R.id.group_social2,
                R.id.s21,
                R.id.s22,
                R.id.s23,
                R.id.s24,0));

        LISTA_SOCIAL.add(new Captacion_funcional("Actitud con el Árbitro",R.id.opcion_social3,
                R.id.group_social3,
                R.id.s31,
                R.id.s32,
                R.id.s33,
                R.id.s34,0));
        LISTA_SOCIAL.add(new Captacion_funcional("Actitud con el Público",R.id.opcion_social4,
                R.id.group_social4,
                R.id.s41,
                R.id.s42,
                R.id.s43,
                R.id.s44,0));

        LISTA_TECNICO.add(new Captacion_funcional("Control de Balones",R.id.opcion_tecnico1,
                R.id.group_tecnico1,
                R.id.t11,
                R.id.t12,
                R.id.t13,
                R.id.t14,0));

        LISTA_TECNICO.add(new Captacion_funcional("Pases largos y entre líneas",R.id.opcion_tecnico2,
                R.id.group_tecnico2,
                R.id.t21,
                R.id.t22,
                R.id.t23,
                R.id.t24,0));

        LISTA_TECNICO.add(new Captacion_funcional("Tiros libres",R.id.opcion_tecnico3,
                R.id.group_tecnico3,
                R.id.t31,
                R.id.t32,
                R.id.t33,
                R.id.t34,0));


        LISTA_TECNICO.add(new Captacion_funcional("Juego y Técnica de Cabeceo",R.id.opcion_tecnico4,
                R.id.group_tecnico4,
                R.id.t41,
                R.id.t42,
                R.id.t43,
                R.id.t44,0));


        LISTA_TECNICO.add(new Captacion_funcional("Dribbling (1 vs 1)",R.id.opcion_tecnico5,
                R.id.group_tecnico5,
                R.id.t51,
                R.id.t52,
                R.id.t53,
                R.id.t54,0));


        LISTA_TECNICO.add(new Captacion_funcional("Técnica de centro",R.id.opcion_tecnico6,
                R.id.group_tecnico6,
                R.id.t61,
                R.id.t62,
                R.id.t63,
                R.id.t64,0));


        LISTA_PSICO.add(new Captacion_funcional("Liderazgo en el campo",R.id.opcion_psico1,
                R.id.group_psico1,
                R.id.p11,
                R.id.p12,
                R.id.p13,
                R.id.p14,0));
        LISTA_PSICO.add(new Captacion_funcional("Soporte emocional al compañero",R.id.opcion_psico2,
                R.id.group_psico2,
                R.id.p21,
                R.id.p22,
                R.id.p23,
                R.id.p24,0));
        LISTA_PSICO.add(new Captacion_funcional("Respeto a la Autoridad y las Reglas",R.id.opcion_psico3,
                R.id.group_psico3,
                R.id.p31,
                R.id.p32,
                R.id.p33,
                R.id.p34,0));
        LISTA_PSICO.add(new Captacion_funcional("Capacidad de sacrificio",R.id.opcion_psico4,
                R.id.group_psico4,
                R.id.p41,
                R.id.p42,
                R.id.p43,
                R.id.p44,0));



    }

}
