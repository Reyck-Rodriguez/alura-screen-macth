package com.aluracurso.ScreenMacht.servicio;

import com.aluracurso.ScreenMacht.molde.datos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class transformer implements miraDatos {
    private ObjectMapper mapiando = new ObjectMapper();

    @Override
    public <T> T cogerDatos(String jeyson, Class<T> clase) {
        try {
            return mapiando.readValue(jeyson, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al parsear JSON", e);
        }
    }
}

