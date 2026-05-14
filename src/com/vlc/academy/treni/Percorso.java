package com.vlc.academy.treni;

import java.util.*;

public class Percorso {
    private String codice;
    private String categoria;
    private boolean straordinario;
    private List<Fermata> fermate = new ArrayList<>();
    List<Treno> treni = new ArrayList<>();

    public Percorso(String codice, String categoria) {
        this.codice = codice;
        this.categoria = categoria;
        straordinario = false;
    }

    public void aggiungiTreno(Treno t) {
        treni.add(t);
    }

    public String getCodice() {
        return codice;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isStraordinario() {
        return straordinario;
    }

    public void setStraordinario(boolean b) {
        this.straordinario = b;

    }

    public Fermata aggiungiFermata(String nomeStazione, int ore, int minuti) {
        Fermata fermata = new Fermata(nomeStazione, ore, minuti);
        fermate.add(fermata);
        return fermata;
    }

    public List<Fermata> getFermate() {
        return fermate
                .stream()
                .sorted(Comparator
                        .comparing(Fermata::getOre)
                        .thenComparing(Fermata::getMinuti))
                .toList();
    }

    public double ritardoFinale() {
        return treni.stream()
                .mapToInt(Treno::ritardoFinale)
                .max()
                .orElse(0);
    }

    public double ritardoMedio() {
        return treni.stream()
                .mapToInt(Treno::ritardoMassimo)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return STR."Percorso - codice: \{codice}, Categoria: \{categoria} è straordinario: \{straordinario}";
    }
}
