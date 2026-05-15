package com.vlc.academy.esercizimirati.EserciziChat.lacune.Azienda;

import java.util.ArrayList;
import java.util.List;

public class Progetto {
    // Può avere più dipendenti
    private String codice;
    private String nome;
    private double budget;

    public Progetto(String codice, String nome, double budget) {
        this.codice = codice;
        this.nome = nome;
        this.budget = budget;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Progetto{" +
                "codice='" + codice + '\'' +
                ", nome='" + nome + '\'' +
                ", budget=" + budget +
                '}';
    }
}
