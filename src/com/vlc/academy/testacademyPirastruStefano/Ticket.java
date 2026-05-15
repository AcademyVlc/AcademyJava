package com.vlc.academy.testacademyPirastruStefano;

import java.time.LocalDate;

public class Ticket {
    private int id;
    private static int contatore = 1;
    private double prezzo;
    private boolean prenotato;

    public Ticket(double prezzo) {
        this.id = contatore++;
        this.prezzo = prezzo;
        this.prenotato = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    @Override
    public String toString() {
        return STR."Id biglietto \{id} con prezzo \{prezzo} euro. Prenotato: \{prenotato} \n";
    }
}
