package com.vlc.academy.esercizimirati.EserciziChat.lacune.Biblioteca;

public class Prestito {
    Libro libro;
    Utente utente;

    public Prestito(Libro libro, Utente utente) {
        this.libro = libro;
        this.utente = utente;
    }

    public Libro getLibro() {
        return libro;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return STR."\{utente.getNome()} --> \{libro.getTitolo()}";
    }
}
