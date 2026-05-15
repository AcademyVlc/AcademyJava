package com.vlc.academy.esercizimirati.EserciziChat.lacune.Azienda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dipendente {
    // Può lavorare su più progetti
    private String matricola;
    private String nome;
    private String ruolo;

    public Dipendente(String matricola, String nome, String ruolo) {
        this.matricola = matricola;
        this.nome = nome;
        this.ruolo = ruolo;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
