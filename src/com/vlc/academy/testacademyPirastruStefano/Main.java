package com.vlc.academy.testacademyPirastruStefano;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static void main() {
//        Event eventoKendrick = new Event("Concerto Kendrick Lamar", "12-5-2027", "Torino", 30000);
//        Ticket ticket1 = new Ticket(13.00);
//        Ticket ticket2 = new Ticket(13.00);
//        System.out.println(eventoKendrick.getData());
//        System.out.println(ticket1.isPrenotato()); // parte da false
//        System.out.println(ticket1.getId()); // id parte da 1
//        System.out.println(ticket2.getId()); // id incrementato di 1 -> 2 -> Quindi id è univoco per tutti i biglietti
        try {
            String obiettivo = """
                    OBIETTIVO: 
                    Implementare un sistema di prenotazione di biglietti per eventi. 
                    Gli utenti possono: visualizzare gli eventi disponibili, prenotare biglietti e ottenere conferme delle prenotazioni.
                    """;
            System.out.println(obiettivo);

            System.out.println("- Creazione BS - Creazione evento - mostraEventi()");
            BookingSystem bs = new BookingSystem();
            Event evento1 = bs.creaEvento("Clash in Italy", LocalDate.of(2026, 5, 31), "Inalpi Arena, Torino", 2); // creo l'evento
            List<Event> listaEventi = bs.mostraEventi();
            System.out.println(listaEventi + "\n"); // Mostra gli eventi appena creati

            System.out.println("- mostraEventoSpecifico() + Gestione eccezione");
            System.out.println(bs.mostraEventoSpecifico("Clash in Italy"));

            System.out.println("\n - prenota() + EventoInesistente");
//            bs.mostraEventoSpecifico("Pluto"); // Eccezione gestita -> Output: L'evento specifico non esiste
            bs.prenota("Clash in Italy", 15);
            bs.prenota("Clash in Italy", 15);
//            bs.prenota("Clash in Italy", 15); // Eccezione gestita -> Output: Il numero di biglietti selezionati non è valido sulla base della quantità rimasta
//            bs.prenota("pippo", 45); // Eccezione gestita -> Output: La prenotazione è fallita poichè l'evento non esiste
            System.out.println("Numero biglietti dopo la prenotazione: " + evento1.getNumeroBigliettiDisponibili()); // Qui i biglietti disponibili passano da 2 a 0 -> Aggiorno effettivamente lo stato dell'evento

            System.out.println("\n----------findAllBiglietti()----------");
            System.out.println(bs.findAllBiglietti());

            System.out.println("\n----------findById() + TicketNotFoundException----------");
            System.out.println(bs.findById(1));
            System.out.println(bs.findById(2));
//            System.out.println(bs.findById(5)); // Eccezione gestita -> Output: Biglietto non trovato

            System.out.println("\n--------------------");
        } catch (BigliettiTerminati | TicketNotFoundException | EventoInesistente e) {
            System.out.println(e.getMessage());
        }
    }
}
