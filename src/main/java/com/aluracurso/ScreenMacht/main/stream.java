package com.aluracurso.ScreenMacht.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stream {
    public void muestra() {
        List<String>nombres = Arrays.asList("junior","Juan", "Pedro", "Maria", "Jose");

        nombres.stream().sorted().filter(n->n.startsWith("j")).forEach(System.out::println);
    }
}
