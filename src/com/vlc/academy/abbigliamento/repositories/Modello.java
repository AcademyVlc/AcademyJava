package com.vlc.academy.abbigliamento.repositories;

public class Modello {
    private String nome;
    private double costoFisso;
    private double quantitaTessuto; // TODO - Da esprimere in metri quadri -> quantità di tessuto richiesta per confezionare il modello

    public Modello(String nome, double costoFisso, double quantitaTessuto) {
        this.nome = nome;
        this.costoFisso = costoFisso;
        this.quantitaTessuto = quantitaTessuto*quantitaTessuto;
    }

    public String getNome(){
        return nome;
    }
    public double getCostoFisso(){
        return costoFisso;
    }

    public double getQuantitaTessuto() {
        return quantitaTessuto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCostoFisso(double costoFisso) {
        this.costoFisso = costoFisso;
    }

    public void setQuantitaTessuto(double quantitaTessuto) {
        this.quantitaTessuto = quantitaTessuto;
    }
}
