package com.vlc.academy.treni;

import java.time.LocalTime;
import java.util.Objects;

public class Fermata {
    private String nomeStazione;
    private int ore;
    private int minuti;

    public Fermata(String nomeStazione, int ore, int minuti) {
        this.nomeStazione = nomeStazione;
        this.ore = ore;
        this.minuti = minuti;
    }

    public String getStazione() {
        return nomeStazione;
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    @Override
    public String toString() {
        return STR."\{nomeStazione} ore: \{ore} minuti: \{minuti}";
    }
}
