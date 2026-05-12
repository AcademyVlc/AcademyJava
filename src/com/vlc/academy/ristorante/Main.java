package com.vlc.academy.ristorante;

import com.vlc.academy.ristorante.exceptions.InvalidName;
import com.vlc.academy.ristorante.repositories.Chain;
import com.vlc.academy.ristorante.repositories.Restaurant;

public class Main {
    public static void main(String[] args) {
        try {
            Chain c1 = new Chain("Raviolo d'oro");
            c1.addRestaurant("Raviolo d'oro", 8);
            c1.addRestaurant("Susanna Ravioli", 200);

            System.out.println("----------Test getRestaurant----------");
            Restaurant r1 = c1.getRestaurant("Raviolo d'oro");
            Restaurant r2 = c1.getRestaurant("Susanna Ravioli");
            System.out.println(r1);
            System.out.println(r2);

//            System.out.println("----------Test Eccezione----------");
//            c1.addRestaurant("Raviolo d'oro", 200);

            System.out.println("----------Test addMenu----------");
            r1.addMenu("Menù Kebab", 10);
            r2.addMenu("Menù Pizza Grande", 12);
            r1.seeMenu();
            r2.seeMenu();
//            System.out.println("----------Test Eccezione addMenu----------");
//            r1.addMenu("Menù Kebab", 10);
//            System.out.println("----------Test Eccezione addRestaurant che crea un ristorante ma solo se ha i tavoli divisibili per 4----------");
//            c1.addRestaurant("pippo", 3);
            System.out.println("----------Test Numero Tavoli----------");
            System.out.println(String.format("Il numero di tavoli presenti in " + r1.getName() + " è di " + r1.getNumeroTavoli() + " tavoli")); // 100 / 4 = 25
            System.out.println(String.format("Il numero di tavoli presenti in " + r2.getName() + " è di " + r2.getNumeroTavoli() + " tavoli"));

            System.out.println("----------Test Prenotazione----------");
            r1.reserve("Pippo", 1);
//            System.out.println("----------Test Prenotazione già esistente e rifiuto----------");
//            r1.reserve("Pippo", 13);
            System.out.println("----------Test Posti esauriti e quindi non è possibile prendere più prenotazioni + Test Persone rifutate----------");
            r1.reserve("Pluto", 2);
            r1.reserve("Pio", 4);
            r1.getRefused();
            System.out.println("----------Test Vedere quanti tavoli sono inutilizzati----------");
            r1.getUnusedTables();
            /**
             * Fine R1 e R2
             */
            System.out.println("----------Test Vedere la lista dei clienti con relativi tavoli prenotati----------");
            r1.seeCustomersBooked();
            /**
             * R3 Orders - testare:
             * order() - getUnordered() - pay() - getUnpaid() - getIncome()
             */
            System.out.println("----------Test order()----------");
            r1.order("Pippo", "Menù Kebab"); // stampa true -> Quindi ordine eseguito da Pippo
            r1.order("Pluto", "Menù Kebab", "Menù Kebab");
            System.out.println("----------Test getUnordered()----------");
            r1.getUnordered(); // stampa Pluto -> in quanto ha prenotato ma non ha ancora ordinato
            System.out.println("----------Test pay()----------");
            r1.pay("Pippo"); // Pippo deve pagare un menù kebab a 10 euro
            System.out.println("----------Test getUnpaid----------");
            r1.getUnpaid(); // Pluto ha ordinato ma non pagato
            System.out.println("----------Test incasso totale----------");
            r1.pay("Pluto");
            r1.getIncome(); // Totale incassato 30 = 3 menù kebab
            r2.getIncome();
            /**
             * R4 - Reports
             */
            System.out.println("----------Test sortByIncome()----------");
            c1.sortByIncome(); // Raviolo d'oro ha incassato 30; Susanna Ravioli 0
            System.out.println("----------Test sortByRefused()----------");
            c1.sortByRefused();
            System.out.println("----------Test sortByUnusedTables()----------");
            c1.sortByUnusedTables();

        } catch (InvalidName e) {
            System.out.println("Errore: " + e.getMessage());
            // Output: Errore: Nome ristoran
        }
    }
}
// metodo che gli passo una lista di stringhe e lui mi restituisce solo i duplicati case insensitive