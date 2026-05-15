package com.vlc.academy.esercizimirati.EserciziChat.lacune.Palestre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CatenaPalestre {
    // Una catena gestisce più palestre. Ogni cliente può sottoscrivere un abbonamento in una palestra.
    private Map<String, Palestra> palestre = new HashMap<>();
    private Map<String, Cliente> clienti = new HashMap<>();
    private List<Abbonamento> abbonamenti = new ArrayList<>();
    private String nomeCatena;

    public CatenaPalestre(String nomeCatena) {
        this.nomeCatena = nomeCatena;
    }

    public Palestra aggiungiPalestra(String nome, String citta) {
        if (nome == null || citta == null) {
            throw new TuttiCampiObbligatori("Tutti i campi sono obbligatori");
        }

        Palestra palestra = new Palestra(nome, citta);
        palestre.put(nome, palestra);
        return palestra;
    }

    public Cliente registraCliente(String codice, String nome, int eta) throws UtenteDuplicato {
        if (codice == null || nome == null || eta < 0) {
            throw new TuttiCampiObbligatori("Tutti i campi sono obbligatori e l'età dev'essere positiva");
        }

        if (clienti.containsKey(codice)){
            throw new UtenteDuplicato("Utente già registrato, il codice è unico");
        }

        Cliente cliente = new Cliente(codice, nome, eta);
        clienti.put(codice, cliente);
        return cliente;
    }

    public Abbonamento creaAbbonamento(String codiceCLiente, String nomePalestra, TipoAbbonamento tipo, double prezzoMensile) {
        Cliente cliente = clienti.get(codiceCLiente);
        Palestra palestra = palestre.get(nomePalestra);
        Abbonamento abbonamento = new Abbonamento(cliente, palestra, tipo, prezzoMensile);
        palestra.aggiungiCliente(cliente);
        abbonamenti.add(abbonamento);
        return abbonamento;
    }

    public List<Cliente> clientiPerPalestra(String nomePalestra) {
        return palestre.values()
                .stream()
                .filter(p -> p.getNome().equals(nomePalestra))
                .findFirst()
                .map(Palestra::clientiPalestra)
                .orElseThrow(() -> new RuntimeException("Palestra non trovata"));
    }

    public double incassoMensileTotale(Palestra palestra) {
        return abbonamenti
                .stream()
                .mapToDouble(Abbonamento::getPrezzoMensile)
                .sum();
    }

    public Map<String, List<Cliente>> clientiRaggruppatiPerTipoAbbonamento() {
        return abbonamenti.stream()
                                                         //Questo crea le chiavi "VIP", "BASE"...
                .collect(Collectors.groupingBy(a -> a.getTipo().name(),
                        Collectors.mapping(Abbonamento::getCliente, Collectors.toList()
                                // Per ogni abbonamento salva il CLiente             Mettili in una lista
                )));
        /**
         *  Risultato
         *  "VIP" = [Mario, Luca]
         *  "BASE" = [Mario, Luca]
         *   -> .name() è un metodo proprio degli enum che restituisce il valore dell'enum in stringa
         */
    }

}
