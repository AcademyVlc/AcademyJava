package com.vlc.academy.treni;

import java.util.ArrayList;
import java.util.List;

public class Passaggio {
    private Fermata fermata;
    private int ore;
    private int minuti;

    public Passaggio(Fermata fermata, int ore, int minuti) {
        this.fermata = fermata;
        this.ore = ore;
        this.minuti = minuti;
    }

    public Fermata getFermata() {
        return fermata;
    }

    public void setFermata(Fermata fermata) {
        this.fermata = fermata;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public String getStazione() {
        return fermata.getStazione();
    }

    public int getMinuti() {
        return minuti;
    }

    public int ritardo() {
        int previsti = fermata.getOre() * 60 + fermata.getMinuti();
        int reali = ore * 60 + minuti;

//        System.out.println("Previsti: " + previsti);
//        System.out.println("Reali: " + reali);

        return reali - previsti;
    }

    @Override
    public String toString() {
        return "Passaggio{" +
                "fermata=" + fermata +
                ", ore=" + ore +
                ", minuti=" + minuti +
                '}';
    }
}
