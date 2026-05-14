package com.vlc.academy.treni;

public class MainTreni {
    static void main(String[] args) {
        Orari orari = new Orari();
        /**
         * ---------------- R1 ----------------
         * Creazione percorsi
         */
        Percorso p1 = orari.creaPercorso("IC2345", "Intercity");
        Percorso p2 = orari.creaPercorso("ES999", "Eurostar");
        System.out.println("----- TEST R1 -----");
        System.out.println(p1.getCodice()); // IC2345
        System.out.println(p1.getCategoria()); // Intercity
        System.out.println(p1.isStraordinario()); // false
        p1.setStraordinario(true);

        System.out.println(p1.isStraordinario()); // true
        System.out.println("\nTutti i percorsi:");
        orari.getPercorsi()
                .forEach(p -> System.out.println(
                        p.getCodice() + " - " + p.getCategoria()
                ));

        System.out.println("\nRicerca percorso:");

        Percorso trovato = orari.getPercorso("IC2345"); // trovato conterrà il percorso
        System.out.println(
                trovato.getCodice() + " - " + trovato.getCategoria() // Stampo codice e categoria del percorso trovato
        );
        /**
         * ---------------- R2 ----------------
         * Fermate
         */
        System.out.println("\n----- TEST R2 -----");
        Fermata fermataTorino = p1.aggiungiFermata("Torino", 16, 45); // Riusata sotto per test ritardo 16.45 - 16.50
        Fermata fermataMilano = p1.aggiungiFermata("Milano", 18, 00);
        p1.aggiungiFermata("Novara", 11, 30);
        p1.aggiungiFermata("Roma", 15, 5);

        System.out.println("\nLista fermate ordinate:");
        p1.getFermate()
                .forEach(System.out::println);
        /**
         * ---------------- R3 ----------------
         * Treni
         */
        System.out.println("\n----- TEST R3 -----");
        try {
            Treno t1 = orari.nuovoTreno(p1.getCodice(), 15, 8, 2026);
            Treno t2 = orari.nuovoTreno(p1.getCodice(), 15, 8, 2025);
            Treno t3 = orari.nuovoTreno(p1.getCodice(), 15, 8, 2024);
            System.out.println("\nElenco treni decrescente: ");
            orari.getTreni().forEach(System.out::println);
            System.out.println("\nTest metodi: getPercorso() - getGiorno() - getMese() - getAnno()");
            System.out.println(t1.getPercorso());
            System.out.println(t1.getGiorno());
            System.out.println(t1.getMese());
            System.out.println(t1.getAnno());
            /**
             * ---------------- R4 ----------------
             * Passaggi
             */
            System.out.println("\n----- TEST R4 -----");
            System.out.println(t1.arrivato()); // Qui il treno non è ancora arrivato, quindi non viene registrato alcun passaggio
            Passaggio pass1 = t1.registraPassaggio(fermataTorino, 16, 50); // passaggio alle 16.50 e doveva passare a 45 --> Il treno alle 16.50 è arrivato a Torino
            Passaggio pass2 = t1.registraPassaggio(fermataMilano, 18, 30);
            System.out.println(STR."Ritardo del \{t1} di \{pass1.ritardo()} minuti"); // Ritardo 5
            System.out.println(STR."Ritardo del \{t1} di \{pass2.ritardo()} minuti"); // Ritardo 30
            /**
             * ---------------- R5 ----------------
             * Statistiche
             */
            System.out.println("\n----- TEST R5 -----");
            System.out.println(t1.arrivato()); // Dopo che registro il passaggio allora il treno risulta essere arrivato --> Riga 59
            System.out.println(STR."Il ritardo massimo registrato è di \{t1.ritardoMassimo()} minuti");
            System.out.println(STR."Il ritardo finale registrato è di \{t1.ritardoFinale()} minuti"); // 35 minuti perchè è il ritardo complessivo
            System.out.println(STR."Ritardo medio, ricavato da Percorso: \{p1.ritardoMedio()}");
            System.out.println(STR."Ritardo finale, ricavato da Percorso:\{p1.ritardoFinale()}");

        } catch (PercorsoNonValido | StazioneNonValida e) {
            System.out.println(e.getMessage());
        }


    }
}
