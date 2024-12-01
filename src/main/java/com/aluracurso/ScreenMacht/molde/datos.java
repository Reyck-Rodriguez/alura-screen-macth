package com.aluracurso.ScreenMacht.molde;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.fasterxml.jackson.annotation.JsonAlias;
@JsonIgnoreProperties(ignoreUnknown = true)
public record datos (
    @JsonAlias("Title") String titulo,
    @JsonAlias("totalSeasons") int temporadas,
    @JsonAlias("Value") String evaluacion,
    @JsonAlias("Genre") String genero,
    @JsonAlias("Released") String anoteDeEstreno,
    @JsonAlias("Runtime") String duracion,
    @JsonAlias("Actors") String actores ){

}