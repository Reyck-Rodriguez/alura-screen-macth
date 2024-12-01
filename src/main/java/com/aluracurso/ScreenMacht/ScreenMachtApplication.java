package com.aluracurso.ScreenMacht;

import com.aluracurso.ScreenMacht.main.main;
import com.aluracurso.ScreenMacht.main.stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScreenMachtApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenMachtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        main menu = new main();
        menu.muestro();
        stream nombre = new stream();
        nombre.muestra();

    }

}
