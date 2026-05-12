package com.vlc.academy.abbigliamento.repositories;

public class Capo {
    Modello modello;
    Materiale materiale;
    Colore colore;

    public Capo(Modello modello, Materiale materiale, Colore colore) {
        this.modello = modello;
        this.materiale = materiale;
        this.colore = colore;
    }

    public Modello getModello() {
        return modello;
    }

    public void setModello(Modello modello) {
        this.modello = modello;
    }

    public Materiale getMateriale() {
        return materiale;
    }

    public void setMateriale(Materiale materiale) {
        this.materiale = materiale;
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }

    public double prezzo() {
        return modello.getCostoFisso() + modello.getQuantitaTessuto() * materiale.getCosto();
    }

    @Override
    public String toString() {
        String result = STR."Modello: \{modello.getNome()}, colore: \{colore.getNome()} di materiale: \{materiale.getNome()}";
        return result;
    }
}
