package com.vlc.academy.abbigliamento.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Abbigliamento {
    Map<String, Modello> modelli = new HashMap<>();
    Map<String, Materiale> materiali = new HashMap<>();
    Map<String, Colore> colori = new HashMap<>();
    Map<String, Capo> capi = new HashMap<>();
    Map<String, Collezione> collezioni = new HashMap<>();

    public void leggiFile(String fileName) throws IOException {
        Files.lines(Path.of(fileName))
                .map(s -> s.split(";"))
                .forEach(array -> System.out.println(Arrays.toString(array)));
    }

    public Modello getModello(String name) {
        return null;
    }

    public Colore getColore(String name) {
        return null;
    }

    public Materiale getMateriale(String name) {
        return null;
    }

    public Capo getCapo(String name) {
        return null;
    }

    public Collezione getCollezione(String name) {
        return null;
    }
}
