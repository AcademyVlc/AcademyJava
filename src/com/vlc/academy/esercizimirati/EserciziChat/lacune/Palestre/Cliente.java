package com.vlc.academy.esercizimirati.EserciziChat.lacune.Palestre;

public class Cliente {
    private String codice;
    private String nome;
    private int eta;

    public Cliente(String codice, String nome, int eta) {
        this.codice = codice;
        this.nome = nome;
        this.eta = eta;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return STR."Nome cliente: \{nome} - Età: \{eta} - Codice ID: \{codice}----------";
    }
}
