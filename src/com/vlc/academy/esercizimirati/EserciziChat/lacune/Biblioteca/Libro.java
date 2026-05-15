package com.vlc.academy.esercizimirati.EserciziChat.lacune.Biblioteca;

public class Libro {
    private String codice;
    private String titolo;
    private String autore;
    private int copie;

    public Libro(String codice, String titolo, String autore, int copie) {
        this.codice = codice;
        this.titolo = titolo;
        this.autore = autore;
        this.copie = copie;
    }

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getCopie() {
        return copie;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setCopie(int copie) {
        this.copie = copie;
    }

    @Override
    public String toString() {
        return titolo;
    }
}
