package com.vlc.academy.abbigliamento.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collezione {
    List<Capo> capi = new ArrayList<>();

    public Collezione(){
         this.capi = capi;
    }

    public void add(Capo capo) {
        capi.add(capo);
    }

    public Collection trova(Colore colore) {
        return capi.stream()
                .filter(c -> c.getColore().equals(colore))
                .toList();
    }

    public Collection trova(Materiale materiale) {
        return capi.stream()
                .filter(c -> c.getMateriale().equals(materiale))
                .toList();
    }

    public Collection trova(Modello modello) {
        return capi.stream()
                .filter(c -> c.getModello().equals(modello))
                .toList();
    }

    public void mostraTuttiCapi() {
        capi.stream()
                .forEach(System.out::println);
    }
}
