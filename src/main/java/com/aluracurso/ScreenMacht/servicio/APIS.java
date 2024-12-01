package com.aluracurso.ScreenMacht.servicio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIS {

    public String cogerDatos(String Url) throws IOException, InterruptedException {
        HttpClient servidor = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(Url)).build();
        HttpResponse<String> respuesta = servidor.send(peticion, HttpResponse.BodyHandlers.ofString());
        try {
            respuesta = servidor.send(peticion, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            System.out.println("Error en la petición: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Error en la espera: " + e.getMessage());
            throw new RuntimeException(e);
        }
        String jeyson = respuesta.body();
        return jeyson;
    }
}
