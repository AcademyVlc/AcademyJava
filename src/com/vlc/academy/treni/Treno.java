package com.vlc.academy.treni;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Treno {
    private Percorso percorso;
    private int id;
    private int giorno;
    private int mese;
    private int anno;
    private static int contatore = 0;
    private List<Passaggio> passaggi = new ArrayList<>();
    private boolean arrivato;

    public Treno(Percorso percorso, int giorno, int mese, int anno) {
        this.percorso = percorso;
        this.id = contatore++;
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.arrivato = false;
    }

    public Percorso getPercorso() {
        return percorso;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }

    public LocalDate getData(){
        return LocalDate.of(anno, mese, giorno);
    }

    public Passaggio registraPassaggio(Fermata fermataNome, int ora, int minuti) throws StazioneNonValida {
        Fermata f = percorso.getFermate()
                .stream()
                .filter(fermata -> fermata.getStazione().equals(fermataNome.getStazione()))
                .findFirst()
                .orElseThrow();
        Passaggio passaggio = new Passaggio(fermataNome, ora, minuti);
        passaggi.add(passaggio);
        arrivato = true;
        return passaggio;
    }

    public boolean arrivato() {
        return arrivato;
    }

    public int ritardoMassimo() {
        return passaggi.stream()
                .mapToInt(Passaggio::ritardo) // ritardo restiuisce un int
                .max()
                .orElse(0);
    }

    public int ritardoFinale() {
        return passaggi.stream()
                .mapToInt(Passaggio::ritardo)
                .sum();
    }

    @Override
    public String toString() {
        return STR."Treno con id \{id} -> \{getData()}";
    }
}
