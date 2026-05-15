package com.vlc.academy.esercizimirati.EserciziChat.lacune.Azienda;

public class Assegnazione {
    private Dipendente dipendente;
    private Progetto Progetto;
    private int oreSettimanali;

    public Assegnazione(Dipendente dipendente, Progetto Progetto, int oreSettimanali) {
        this.dipendente = dipendente;
        this.Progetto = Progetto;
        this.oreSettimanali = oreSettimanali;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Progetto getProgetto() {
        return Progetto;
    }

    public void setProgetto(Progetto progetto) {
        this.Progetto = progetto;
    }

    public int getOreSettimanali() {
        return oreSettimanali;
    }

    public void setOreSettimanali(int oreSettimanali) {
        this.oreSettimanali = oreSettimanali;
    }
}
