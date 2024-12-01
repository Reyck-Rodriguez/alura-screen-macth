package com.aluracurso.ScreenMacht.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.aluracurso.ScreenMacht.molde.epistola;
import com.aluracurso.ScreenMacht.molde.shimisodio;
import com.aluracurso.ScreenMacht.molde.tempurmisho;
import com.aluracurso.ScreenMacht.servicio.APIS;
import com.aluracurso.ScreenMacht.servicio.transformer;

public class main {

    private final String url = "https://www.omdbapi.com/?t=";
    private final String apiKey = "&apikey=87ef29b";
    private Scanner metio = new Scanner(System.in);
    private Scanner metio2 = new Scanner(System.in);
    private APIS laApi = new APIS();
    private transformer trans = new transformer();


    public void muestro() throws IOException, InterruptedException {

        System.out.println("por favor escribe el nombre de la serie que deseas buscar");
        var laserie = metio.nextLine();
        var justin = laApi.cogerDatos(url + laserie.replace(" ", "+") + apiKey);
        var datos = trans.cogerDatos(justin, com.aluracurso.ScreenMacht.molde.datos.class);
        System.out.println(datos);
        /* justyn y su datos */
        List<tempurmisho> tempurmishoList = new ArrayList<>();
        for (int i = 1; i <= datos.temporadas(); i++) {
            justin = laApi.cogerDatos(url + laserie.replace(" ", "+") + "&Season=" + i + apiKey);
            var tempurmisho = trans.cogerDatos(justin, tempurmisho.class);
            tempurmishoList.add(tempurmisho);

        }
//        tempurmishoList.forEach(System.out::println);
        /*mapeo de peek*/
        tempurmishoList.forEach(t -> t.epi().forEach(e -> System.out.println(e.titulo())));
        List<shimisodio> epi = tempurmishoList.stream().flatMap(t -> t.epi().stream()).collect(Collectors.toList());
        System.out.println("numero 5 evaluados");
////        epi.stream().filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("primer filtro (n/a) " + e))
//                .sorted(Comparator.comparing(shimisodio::evaluacion))
//                .peek(e -> System.out.println("segundo orden (Mayor a menor) " + e)).limit(5)
//                .peek(e -> System.out.println("tercer limitador (5 ) " + e)).map(e -> e.titulo().toUpperCase(Locale.ROOT))
//                .peek(e -> System.out.println("cuarto mapeo " + e)).forEach(System.out::println);
        List<epistola> listaEpisodios = tempurmishoList.stream().flatMap(t -> t.epi().stream().map(d -> new epistola(t.temporada(), d))).collect(Collectors.toList());
        /*pregutna por año*/
//        while (true) {
//            System.out.println("Episodios ordenados por fecha de estreno por que año quieres ?");
//            var preg = metio.nextInt();
//            if (preg < 1500 || preg > 9999) {
//                System.out.println("Introduce un año válido");
//            } else {
//                LocalDate año = LocalDate.of(preg, 1, 1);
//                DateTimeFormatter orgFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//                listaEpisodios.stream().filter(A -> A.getFecha() != null && A.getFecha().isAfter(año)).forEach(e -> System.out.println(
//                        "temporada " + e.getNumero() + ", episodio " + e.getEpisodio() + ", título " + e.getTitulo() + ", fecha de estreno " +
//                                e.getFecha().format(orgFecha)));
//            }
//            break;
//
//        }
        /*Pregunta de nombre episodio*/
//        System.out.println("dime el nombre de un episodio que quieras buscar ");
//
//        String pregu = metio2.nextLine();
//        System.out.println(pregu);
//
//        Optional<epistola> primer = listaEpisodios.stream().filter(e -> e.getTitulo().toUpperCase().contains(pregu.toUpperCase())).findFirst();
//        if (primer.isPresent()) {
//            System.out.println("Episodio encontrado: " + primer.get());
//        } else {
//            System.out.println("No hay ningún episodio con ese título");
//        }
        Map<Integer, Double> eva = listaEpisodios.stream()
                .filter(e ->e.getEvaluacion()>0.0).collect(Collectors.groupingBy(epistola::getNumero, Collectors.averagingDouble(epistola::getEvaluacion)));
        System.out.println(eva);

        DoubleSummaryStatistics est = listaEpisodios.stream().filter(e->e.getEvaluacion()>0.0).collect(Collectors.summarizingDouble(epistola::getEvaluacion));
        System.out.println("media evaluada es:"+ est.getAverage()+"\n espisodio menos evaluacion es: "+est.getMin()+
                "\n episodio con mayor evaluacion es: "+est.getMax());
    }
}
