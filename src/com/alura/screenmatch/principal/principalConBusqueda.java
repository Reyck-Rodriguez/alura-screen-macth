package com.alura.screenmatch.principal;

import com.alura.screenmatch.exception.ErrorEnConversionException;
import com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.alura.screenmatch.modelos.tituloOmb;
import com.google.gson.GsonBuilder;

public class principalConBusqueda {

    public void main(String[] args) throws IOException, InterruptedException {

        Scanner ingreso = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();



        while (true) {
            System.out.println("escribe el nombre de la peli");
            var busqueda = ingreso.nextLine();
            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }
            String direccion = "http://omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=87ef29b";
            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(response.body());



                tituloOmb tituloombd = gson.fromJson(json, tituloOmb.class);

                Titulo titulo = new Titulo(tituloombd);
                System.out.println("titulo mostrado " + titulo);

                titulos.add(titulo);

            } catch (NumberFormatException e) {
                System.out.println("No se ha encontrado la pelicula");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la uri Verifique la url");
                System.out.println(e.getMessage());
            } catch (ErrorEnConversionException e) {
                System.out.println(e.getMenssaje());
            }
        }
        System.out.println(titulos);
        FileWriter escritor = new FileWriter("pelis.txt");
        escritor.write(gson.toJson(titulos));
        escritor.close();
        System.out.println("finalizo la busqueda");

    }
}
