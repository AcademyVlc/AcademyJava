package com.vlc.academy.esercizimirati.EserciziChat.lacune.Azienda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Azienda {
    private String nomeAzienda;
    private Map<String, Dipendente> dipendenti = new HashMap<>();
    private Map<String, Progetto> progetti = new HashMap<>();
    private List<Assegnazione> assegnazioni = new ArrayList<>();

    public Azienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public Dipendente assumiDipendente(String matricola, String nome, String ruolo) {
        Dipendente dipendente = new Dipendente(matricola, nome, ruolo);
        dipendenti.put(matricola, dipendente);
        return dipendente;
    }

    public Progetto creaProgetto(String codice, String nome, double budget) {
        Progetto progetto = new Progetto(codice, nome, budget);
        progetti.put(codice, progetto);
        return progetto;
    }

    public Assegnazione assegna(Dipendente dipendente, Progetto progetto, int oreSettimanali) {
        Assegnazione assegnazione = new Assegnazione(dipendente, progetto, oreSettimanali);
        assegnazioni.add(assegnazione);
        return assegnazione;
    }

    public List<Dipendente> dipendentiDiProgetto(String codiceProgetto){
        return assegnazioni.stream()
                .filter(a -> a.getProgetto().getCodice().equals(codiceProgetto))
                .map(Assegnazione::getDipendente)
                .toList();
    }

    public List<Progetto> progettiDiDipendenti(String matricola){
        return assegnazioni.stream()
                .filter(a -> a.getDipendente().getMatricola().equals(matricola))
                .map(Assegnazione::getProgetto)
                .toList();
    }

    public Map<String, Long> numeroDipendentiPerProgetto(){
        return assegnazioni.stream()
                // Codice progetto è la chiave Stringa, Collectors counting conta i dipendenti e restituisce un Long
                .collect(Collectors.groupingBy(a -> a.getProgetto().getCodice(), Collectors.counting()));
    }

    public Optional<Progetto> progettoConBudgetMaggiore(){
        return progetti.values()
                .stream()
                .max(Comparator.comparingDouble(Progetto::getBudget));
    }
}
