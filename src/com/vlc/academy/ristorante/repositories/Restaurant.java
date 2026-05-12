package com.vlc.academy.ristorante.repositories;

import com.vlc.academy.ristorante.exceptions.InvalidName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private String nomeRistorante;
    private int numeroTavoliTotali;
    private int numeroPostiRistorante;
    private int numeroTavoliDisponibili;
    private Map<String, Double> menuLista = new HashMap<>(); // Menù pasta al sugo, 15euro
    private Map<String, Integer> clientiPrenotati = new HashMap<>();
    private int personeRifiutate; // Variabile contatore che mi dice quante persone non trovano posto
    private List<String> clientiCheHannoOrdinato = new ArrayList<>();
    private Map<String, List<String>> ordini = new HashMap<>();
    private List<String> clientiCheHannoPagato = new ArrayList<>();
    private double incassoTotale = 0;


    public Restaurant(String nomeRistorante, int numeroPostiRistorante) {
        if (numeroPostiRistorante % 4 != 0) {
            throw new IllegalArgumentException("Il numero di tavoli del ristorante deve essere divisibile per 4. In quanto i tavoli hanno 4 posti fissi"); // TEST FATTO
        }
        this.nomeRistorante = nomeRistorante;
        this.numeroPostiRistorante = numeroPostiRistorante; // ipotizza 100
        numeroTavoliTotali = numeroPostiRistorante / 4; // Gestisco quanti tavoli sono disponibili alla creazione del ristorante = 25 tavoli
        numeroTavoliDisponibili = numeroTavoliTotali; // 25
    }

    public String getName() {
        return nomeRistorante;
    }

    public int getNumeroTavoli() {
        return numeroTavoliTotali;
    }


    /**
     * addMenu() permette di aggiungere un menù alla carta del ristorante, e riceve due argomenti:
     * il nome del menù ed il suo prezzo; se il nome è già presente nella carta, solleva l'eccezione InvalidName.
     *
     * @param name
     * @param price
     * @throws InvalidName
     */
    public void addMenu(String name, double price) throws InvalidName {
        boolean exists = menuLista
                .keySet()
                .stream()
                .anyMatch(k -> k.equals(name));

        if (exists) {
            throw new InvalidName("Nome menù già esistente");
        } else {
            menuLista.put(name, price);
            System.out.println("Il " + name + " che costa " + price + "$ è stato aggiunto con successo!");
        }
    }

    /**
     * Metodo customizzato che mi permette di vedere l'elenco dei menù
     */
    public void seeMenu() {
        menuLista.entrySet()
                .forEach(System.out::println);
    }

    /**
     * reserve() permette ad un gruppo di commensali di riservare dei tavoli, e riceve due argomenti:
     * il nome di un referente del gruppo, ed il numero di commensali; se il nome è già stato usato da un altro gruppo, solleva l’eccezione InvalidName.
     * I commensali vengono disposti su tavoli da quattro posti ciascuno, che vengono riservati al gruppo.
     * Se i tavoli disponibili non sono sufficienti, l’operazione viene rifiutata.
     * Il metodo restituisce il numero di tavoli riservati al gruppo (zero se non ci sono tavoli a sufficienza).
     *
     * @param name
     * @param persons
     * @return
     * @throws InvalidName
     */
    public int reserve(String name, int persons) throws InvalidName {
        boolean exists = clientiPrenotati
                .keySet()
                .stream()
                .anyMatch(k -> k.equals(name));
        if (exists) {
            throw new InvalidName("Nome prenotazione già esistente, cambiare nome identificativo");
        } else {
            int tavoliRichiesti = (persons + 3) / 4; // cosi ho sempre un intero x il numero di tavoli
            if (numeroTavoliDisponibili >= tavoliRichiesti) {
                numeroTavoliDisponibili -= tavoliRichiesti;
                clientiPrenotati.put(name, persons); // Salvo i clienti prenotati dentro la mappa
                System.out.println("Prenotazione a nome " + name + " avvenuta con successo per " + persons + " persone. Tavoli riservati: " + tavoliRichiesti);
                return tavoliRichiesti;
            } else {
                System.out.println("Ci dispiace, non ci sono più tavoli disponibili");
                personeRifiutate += persons;
                return 0;
            }
        }
    }

    public int getRefused() {
        System.out.println(STR."Il numero di persone rifiutate dal ristorante \{nomeRistorante} è di: " + personeRifiutate);
        return personeRifiutate;
    }

    public int getUnusedTables() {
        System.out.println(STR."Numero di tavoli inutilizzati dal ristorante \{nomeRistorante}: \{numeroTavoliDisponibili}");
        return numeroTavoliDisponibili;
    }

    public void seeCustomersBooked() {
        System.out.println("La lista dei nomi dei clienti prenotati con relativi tavoli prenotati");
        clientiPrenotati.forEach((nome, tavoli) -> System.out.println("Nome cliente: " + nome + " ha prenotato " + tavoli + " tavoli"));
    }

    public boolean order(String name, String... menu) throws InvalidName {
        if (!clientiPrenotati.containsKey(name)) {
            throw new InvalidName("Non sei prenotato, non puoi ordinare nessun menù");
        }
        for (String m : menu) {
            if (!menuLista.containsKey(m)) {
                throw new InvalidName("Nome del menù errato o non presente nella lista dei menù");
            }
        }
        int numeroPersone = clientiPrenotati.get(name); // numero di persone
        if (menu.length >= numeroPersone) {
            boolean ordineEffettuato = true;
            System.out.println(STR."Ordine effettuato: \{ordineEffettuato}");
            clientiCheHannoOrdinato.add(name);
            ordini.put(name, List.of(menu));
            return ordineEffettuato;
        }
        return false;
    }

    public List<String> getUnordered() {
        System.out.println("Di seguito la lista di clienti che non hanno effettuato ordini: ");
        List<String> list = clientiPrenotati
                .keySet()
                .stream()
                .filter(nome -> !clientiCheHannoOrdinato.contains(nome))
                .sorted()
                .toList();
        list.forEach(System.out::println);
        return list;
    }

    public double pay(String name) throws InvalidName {
        if (!clientiPrenotati.containsKey(name)) {
            throw new InvalidName("Il referente non ha riservato tavoli");
        }

        if (!ordini.containsKey(name)) {
            return 0.0;
        }

        double totaleDaPagare = ordini.get(name)
                .stream()
                .mapToDouble(menu -> menuLista.get(menu)) // per ogni nome menù ordinato prende il prezzo della mappa -> Es: Menù Kebab -> 10.0
                .sum();
        clientiCheHannoPagato.add(name);
        incassoTotale += totaleDaPagare;
        System.out.println(STR."Il totale da pagare per \{name} è di: \{totaleDaPagare}");
        return totaleDaPagare;
    }
// FILTER VUOLE SEMPRE UNA LAMBDA
    public List<String> getUnpaid() {
        List<String> list = clientiCheHannoOrdinato.stream().filter(name -> !clientiCheHannoPagato.contains(name)).sorted().toList();
        System.out.println("Di seguito la lista dei clienti che hanno ordinato ma NON PAGATO: ");
        list.forEach(System.out::println);
        return list;
    }

    public double getIncome() {
        System.out.println(STR."Il totale incassato dal ristorante \{nomeRistorante} è di \{incassoTotale} euro ");
        return incassoTotale;
    }

    @Override
    public String toString() {
        return String.format(STR."Nome ristorante: \{nomeRistorante} con \{numeroPostiRistorante} posti");
    }
}
