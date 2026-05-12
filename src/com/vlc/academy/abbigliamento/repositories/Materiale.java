package com.vlc.academy.abbigliamento.repositories;

public class Materiale {
    private String nome;
    private double costo; // TODO - costo al metro quadro

    public Materiale(String nome, double costo) {
        this.nome = nome;
        this.costo = costo;
    }

    public String getNome(){
        return nome;
    }

    public double getCosto(){
        return costo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
