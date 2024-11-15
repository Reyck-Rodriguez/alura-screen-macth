package com.alura.screenmatch.exception;

public class ErrorEnConversionException extends RuntimeException {
    private String mensaje;


    public ErrorEnConversionException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMenssaje() {
        return mensaje;
    }

}
