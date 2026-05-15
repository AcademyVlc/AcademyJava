package com.vlc.academy.esercizimirati.EserciziChat.lacune.Biblioteca;

public class Utente {
    private String codiceFiscale;
    private String nome;

    public Utente(String codiceFiscale, String nome) {
        if(codiceFiscale.length() != 8){
            throw new CodiceFiscaleSbagliato("Codice Fiscale errato, devono essere 8 caratteri");
        }
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
