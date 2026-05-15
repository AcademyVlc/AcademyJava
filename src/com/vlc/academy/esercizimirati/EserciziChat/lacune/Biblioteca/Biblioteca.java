package com.vlc.academy.esercizimirati.EserciziChat.lacune.Biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    // Biblioteca gestisce libri, utenti e prestiti.
    private String nomeBiblioteca;
    private Map<String, Libro> libri = new HashMap<>(); // X65rt - Promessi Sposi
    private Map<String, Utente> utenti = new HashMap<>(); // PRSSFN01 - Stefano
    private List<Prestito> prestiti = new ArrayList<>();

    public Biblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    // Questo metodo aggiunge un libro in libri, ma non vuole duplicati
    public Libro aggiungiLibro(String codice, String titolo, String autore, int copie) throws CodiceDuplicato {

        boolean contains = libri.containsKey(codice);

        if (contains) {
            throw new CodiceDuplicato("Codice già esistente, impossbile inserire un nuovo libro con quel codice");
        }

        Libro libro = new Libro(codice, titolo, autore, copie);

        libri.put(codice, libro);

        return libro;
    }

    public Utente aggiungiUtente(String codiceFiscale, String nome) throws UtenteDuplicato {
        boolean contains = utenti.containsKey(codiceFiscale);

        if (contains) {
            throw new UtenteDuplicato("Utente già registrato con quel codice fiscale");
        }

        Utente utente = new Utente(codiceFiscale, nome);

        utenti.put(codiceFiscale, utente);

        return utente;
    }

    public Prestito prestaLibro(String codiceLibro, String codiceFiscale, int copieVolute) {

        Libro libro = libri.get(codiceLibro);
        Utente utente = utenti.get(codiceFiscale);

        if (libro == null) {
            throw new IllegalArgumentException("Libro non trovato");
        }

        if (utente == null) {
            throw new IllegalArgumentException("Utente non trovato");
        }

        if (libro.getCopie() <= 0) {
            throw new IllegalArgumentException("Copie terminate");
        }

        if (libro.getCopie()-copieVolute < 0){
            throw new IllegalArgumentException("Le copie richieste superano la quantità disponibile");
        }

        Prestito prestito = new Prestito(libro, utente);

        libro.setCopie(libro.getCopie() - copieVolute);

        prestiti.add(prestito);

        return prestito;
    }

    public List<Libro> libriDisponibili(){
        return libri.values()
                .stream()
                .filter(l -> l.getCopie() >= 1)
                .toList();
    }

    public List<Prestito> prestitiUtente(String codiceFiscale){
        return prestiti.stream()
                .filter(p -> p.getUtente().getCodiceFiscale().equals(codiceFiscale))
                .toList();
    }
}
