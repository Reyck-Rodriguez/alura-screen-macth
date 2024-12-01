package com.aluracurso.ScreenMacht.molde;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record tempurmisho(

        @JsonAlias("Season") Integer temporada,
        @JsonAlias("Episodes") List<shimisodio> epi
) {

}