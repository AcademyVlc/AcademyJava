package com.vlc.academy.esercizimirati.EserciziChat.lacune.Azienda;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MainAzienda {
    static void main() {
        Azienda azienda = new Azienda("Barilla");
        Progetto progetto1 = azienda.creaProgetto("001", "Sviluppo B", 25.000);
        Progetto progetto2 = azienda.creaProgetto("002", "Sviluppo B", 25000.000);
        Dipendente dipendente1 = azienda.assumiDipendente("1", "Flavio", "Developer");
        Dipendente dipendente2 = azienda.assumiDipendente("2", "Bob", "Analista");
        Dipendente dipendente3 = azienda.assumiDipendente("3", "Giulio", "Avvocato");
        Assegnazione assegnazione1 = azienda.assegna(dipendente1, progetto1, 40);
        Assegnazione assegnazione2 = azienda.assegna(dipendente2, progetto1, 45);
        Assegnazione assegnazione3 = azienda.assegna(dipendente3, progetto2, 30);

        List<Dipendente> dipendenti1 = azienda.dipendentiDiProgetto(progetto1.getCodice());
        System.out.println("Dipendenti progetto " + progetto1.getCodice() + ": \n" +dipendenti1);
        List<Dipendente> dipendenti2 = azienda.dipendentiDiProgetto(progetto2.getCodice());
        System.out.println("Dipendenti progetto " + progetto2.getCodice() + ": \n" +dipendenti2);

        List<Progetto> progettiDiDipendenti1 = azienda.progettiDiDipendenti(dipendente1.getMatricola());
        System.out.println("\nProgetti del dipendente 1: " + progettiDiDipendenti1);

        Map<String, Long> numeroDipendentiXprogetto = azienda.numeroDipendentiPerProgetto();
        System.out.println("\n" + numeroDipendentiXprogetto); // {Progetto 001=2 dipendenti, Progetto 002=1 dipendenti}

        Optional<Progetto> progettoConBudgetMaggiore = azienda.progettoConBudgetMaggiore();
        System.out.println(progettoConBudgetMaggiore);
    }
}
