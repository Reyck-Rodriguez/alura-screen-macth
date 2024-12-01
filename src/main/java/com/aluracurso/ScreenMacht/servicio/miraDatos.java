package com.aluracurso.ScreenMacht.servicio;

public interface miraDatos {

    <T> T cogerDatos(String jeyson, Class<T> clase);

}

