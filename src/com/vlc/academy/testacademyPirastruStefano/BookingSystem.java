package com.vlc.academy.testacademyPirastruStefano;

import java.time.LocalDate;
import java.util.*;

public class BookingSystem {
    List<Event> eventi = new ArrayList<>();
    List<Ticket> biglietti = new ArrayList<>();

    /**
     * Crea evento e lo aggiunge nella lista eventi
     * @param nome
     * @param data
     * @param luogo
     * @param numeroBigliettiDisponibili
     * @return
     */
    public Event creaEvento(String nome, LocalDate data, String luogo, int numeroBigliettiDisponibili) {
        Event evento = new Event(nome, data, luogo, numeroBigliettiDisponibili);
        eventi.add(evento); // QUI AGGIUNGO GLI EVENTI dopo averli CREATI
        return evento;
    }

    /**
     * Mostra gli eventi disponibili, aggiunti nel metodo precedente
     * @return
     */
    public List<Event> mostraEventi() {
        return eventi.stream()
                .toList();
    }

    /**
     * Mostra un evento specifico
     * Bisogna fornirgli il nome dell'evento
     * @param nome
     */
//    public void mostraEventoSpecifico(String nome) {
//        eventi.stream()
//                .filter(e -> e.getNome().equals(nome))
//                .forEach(System.out::println);
//    }
    public Event mostraEventoSpecifico(String nome) throws EventoInesistente {
        return eventi.stream()
                .filter((e -> e.getNome().equals(nome)))
                .findFirst()
                .orElseThrow(() -> new EventoInesistente("L'evento specifico non esiste"));
    }

    /**
     * Questo metodo permette di prenotare un biglietto alla volta
     * Gestisce dinamicamente la quantità di biglietti disponibili e prenotati
     * Potrebbe lanciare 2 eccezioni (BigliettiTerminati, EventoInesistente) che vengono gestite nel Main
     * @param nomeEvento
     * @param prezzoBiglietto
     * @return
     * @throws BigliettiTerminati
     * @throws EventoInesistente
     */

    public Ticket prenota(String nomeEvento, double prezzoBiglietto) throws BigliettiTerminati, EventoInesistente {

        int numeroBigliettiDaAcquistare = 1;

        for(Event e : eventi){

            if(e.getNome().equals(nomeEvento)){
                int numeroBigliettiAttuale = e.getNumeroBigliettiDisponibili();

                if(numeroBigliettiAttuale - numeroBigliettiDaAcquistare < 0){
                    throw new BigliettiTerminati("Il numero di biglietti selezionati non è valido sulla base della quantità rimasta");
                }

                e.setNumeroBigliettiDisponibili(numeroBigliettiAttuale - numeroBigliettiDaAcquistare);
                Ticket ticket = new Ticket(prezzoBiglietto);
                biglietti.add(ticket);
                ticket.setPrenotato(true);

                System.out.println("Prenotazione Riuscita! \n");
                System.out.println("Di seguito i dettagli dell'evento: -> " + e);
                System.out.println("Info biglietto: -> " + ticket + "\n");
                return ticket;

            } else {
                throw new EventoInesistente("La prenotazione è fallita poichè l'evento non esiste");
            }
        }
        return null;
    }

    /**
     * Questo metodo restituisce una lista contenente tutti i biglietti
     * @return
     */
    public List<Ticket> findAllBiglietti(){
        return biglietti.stream()
                .toList();
    }

    /**
     * Questo metodo effettua una ricerca tramite id all'interno della lista biglietti
     * @param id
     * @return
     * @throws TicketNotFoundException
     */
    public Ticket findById(int id) throws TicketNotFoundException {
        return biglietti.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TicketNotFoundException("Biglietto non trovato"));
    }
}
