package com.aluracurso.ScreenMacht.molde;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record shimisodio(

    @JsonAlias ("Title") String titulo,
    @JsonAlias("Episode") Integer episodio,
    @JsonAlias("imdbRating") String evaluacion,
    @JsonAlias("Released") String fechaEstreno

) {
}
