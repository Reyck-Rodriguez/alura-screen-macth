package com.aluracurso.ScreenMacht.molde;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class epistola {
    private Integer numero;
    private Integer episodio;
    private String titulo;
    private double evaluacion;
    private LocalDate fecha;

    public epistola(Integer numero, shimisodio d) {
        this.numero = numero;
        this.episodio = d.episodio();
        this.titulo = d.titulo();
        try {
            evaluacion = Double.parseDouble(d.evaluacion());
        } catch (NumberFormatException e) {
            this.evaluacion = 0.0;
        }
        try {
            fecha = LocalDate.parse(d.fechaEstreno());
        } catch (DateTimeParseException e) {
            this.fecha = null;
        }

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Integer episodio) {
        this.episodio = episodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return
                "Temporada= "+ numero +
                ", Episodio= " + episodio +
                ", Título= '" + titulo + '\'' +
                ", Evaluación= " + evaluacion +
                ", Fecha de Estreno= " + fecha;
    }

}
