package com.vlc.academy.treni;

import java.util.*;

public class Orari {
    Map<String, Percorso> percorsi = new HashMap<>();
    List<Treno> treni = new ArrayList<>();

    public Percorso creaPercorso(String codice, String categoria) {
        Percorso percorso = new Percorso(codice, categoria);
        percorsi.put(codice, percorso);
        return percorso;
    }

    public Collection<Percorso> getPercorsi() {
        return percorsi.values();
    }

    public Percorso getPercorso(String codice) {
        return percorsi.get(codice);
    }

    public Treno nuovoTreno(String codice, int giorno, int mese, int anno) throws PercorsoNonValido {
        boolean contiene = percorsi.containsKey(codice);
        if (!contiene){
            throw new PercorsoNonValido("Percorso inesistente");
        }
        Percorso percorsoEsistente = percorsi.get(codice);
        Treno treno = new Treno(percorsoEsistente, giorno, mese, anno);
        percorsoEsistente.aggiungiTreno(treno);
        treni.add(treno);
        return treno;
    }

    public List<Treno> getTreni() {
        return treni.stream()
                .sorted(Comparator
                        .comparing(Treno::getData).reversed())
                .toList();
    }
}
