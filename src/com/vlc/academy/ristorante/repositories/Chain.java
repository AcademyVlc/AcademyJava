package com.vlc.academy.ristorante.repositories;

import com.vlc.academy.ristorante.exceptions.InvalidName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chain {
    private String name;
    Map<String, Restaurant> catenaRistoranti = new HashMap<>(); // Raviolo d'argento -> 55 posti

    public Chain(String name) {
        this.name = name;
    }

    public void addRestaurant(String name, int tables) throws InvalidName {
        boolean exists = catenaRistoranti
                .keySet() // prende tutte le chiavi
                .stream()
                .anyMatch(key -> key.equals(name)); // controlla se almeno un match soddisfa la condizione
        if (exists) {
            throw new InvalidName("Nome ristorante già presente, selezionare un altro nome");
        } else {
            Restaurant ristorante = new Restaurant(name, tables);
            catenaRistoranti.put(name, ristorante);
        }
//        if (catenaRistoranti.containsKey(name)) {
//            throw new InvalidName("Nome ristorante già presente, selezionare un altro nome");
//            // Eccezione customizzata
//        }
//        Restaurant ristorante = new Restaurant(name, tables);
//        catenaRistoranti.put(name, tables);
    }

    public Restaurant getRestaurant(String name) throws InvalidName {
        Restaurant r = catenaRistoranti.get(name);
        if (r == null) {
            throw new InvalidName("Ristorante non trovato dentro la catena di ristoranti");
        }
        return r;
    }

    public List<Restaurant> sortByIncome() {
        List<Restaurant> list = catenaRistoranti.values()
                .stream()
                .sorted((r1, r2) -> Double.compare(r2.getIncome(), r1.getIncome()))
                .toList();
        System.out.println(STR."Ecco i ristoranti della catena che hanno incassato di più in ordine decrescente: \n \{list}");

        return list;
    }

    public List<Restaurant> sortByRefused() {
        List<Restaurant> list = catenaRistoranti.values()
                .stream()
                .sorted((r1, r2) -> r1.getRefused() - r2.getRefused())
                .toList();
        System.out.println(STR."Ecco i ristoranti della catena che hanno rifiutato più clienti in ordine crescente: \n \{list}");
        return list;
    }

    public List<Restaurant> sortByUnusedTables() {
        List<Restaurant> list = catenaRistoranti.values().stream()
                .sorted((r1, r2) -> r1.getUnusedTables() - r2.getUnusedTables())
                .toList();
        System.out.println(STR."Ecco i ristoranti della catena che hanno avuto più tavoli inutilizzati in ordine crescente: \n \{list}");
        return list;
    }
}
