package com.vlc.academy.EserciziMirati.EserciziChat.LivelloBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EserciziBase {
    static void main() {
        /**
         * 1. Numeri pari
         *Dato List<Integer> numbers, restituisci una lista contenente solo i numeri pari.
         */
        System.out.println("----------Esercizio 1 = restituisci una lista contenente solo i numeri pari----------");
        List<Integer> listaNumeri = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numeriPari(listaNumeri));
        /**
         * 2. Lunghezza stringhe
         * Dato List<String> words, crea una lista contenente la lunghezza di ogni parola.
         */
        System.out.println("----------Esercizio 2 = Dato List<String> words, crea una lista contenente la lunghezza di ogni parola.----------");
        List<String> listaStringhe = List.of("Ciao", "Salve", "Buongiorno", "Alleluia", "Arco", "arco", "alleluia", "Camaleonte", "");
        System.out.println(listaLunghezzaParole(listaStringhe));
        /**
         * 3. Maiuscole
         * Dato List<String> names, restituisci una nuova lista tutta in uppercase.
         */
        System.out.println("----------Esercizio 3 = restituisci una nuova lista tutta in uppercase.----------");
        System.out.println(listaStringheToUpperCase(listaStringhe));
        /**
         * 4. Somma totale
         * Dato List<Integer> nums, calcola la somma totale usando gli stream.
         */
        System.out.println("----------Esercizio 4 = restituisci una nuova lista tutta in uppercase.----------");
        System.out.println(sommaInteriLista(listaNumeri));
        /**
         *5. Contare elementi
         * Conta quante stringhe iniziano con "A".
         */
        System.out.println("----------Esercizio 5 = Conta quante stringhe iniziano con \"A\".----------");
        System.out.println(contaQuanteStringheInizianoConA(listaStringhe));
        /**
         *6. Ordinare numeri
         * Ordina una lista di interi in ordine crescente.
         */
        System.out.println("----------Esercizio 6 = Ordina una lista di interi in ordine crescente.----------");
        ordinareListaNumeriOrdineCrescente(listaNumeri);
        /**
         *7. Ordinare stringhe per lunghezza
         * Ordina una lista di stringhe dalla più corta alla più lunga.
         */
        System.out.println("----------Esercizio 7 = Ordina una lista di stringhe dalla più corta alla più lunga.----------");
        ordinaListaStringheOrdineCrescente(listaStringhe);
        /**
         *8. Distinct
         * Rimuovi i duplicati da una lista di stringhe.
         */
        System.out.println("----------Esercizio 8 = Rimuovi i duplicati da una lista di stringhe.----------");
        System.out.println(rimuoviDuplicatiListaStringhe(listaStringhe));
        /**
         *9. findFirst()
         * Trova il primo numero multiplo di 7.
         */
        System.out.println("----------Esercizio 9 = Trova il primo numero multiplo di 7.----------");
        System.out.println(trovaIlPrimoNumeroMultiploDi7(listaNumeri));
        /**
         * 10. anyMatch()
         * Verifica se esiste almeno una stringa lunga più di 10 caratteri.
         */
        System.out.println("----------Esercizio 10 = Trova il primo numero multiplo di 7.----------");
        System.out.println(verificaSeAlmenoUnaStringaLungaDieciCaratteri(listaStringhe));
        /**
         * 11. allMatch()
         * Controlla se tutti i numeri sono positivi.
         */
        System.out.println("----------Esercizio 11 = Controlla se tutti i numeri sono positivi----------");
        System.out.println(controllaSeTuttiSonoPositivi(listaNumeri));
        /**
         * 12. noneMatch()
         * Verifica che nessuna stringa sia vuota.
         */
        System.out.println("----------Esercizio 12 = Controlla se tutti i numeri sono positivi----------");
        System.out.println(verificaNessunaStringaVuota(listaStringhe));
        /**
         * 13. Metodo reference semplice
         * Trasforma tutte le stringhe in lowercase usando method reference.
         */
        System.out.println("----------Esercizio 13 = Trasforma tutte le stringhe in lowercase usando method reference----------");
        System.out.println(MethodRefStringheToUpperCase(listaStringhe));
        /**
         * 14. forEach()
         * Stampa ogni elemento preceduto da "Valore: ".
         */
        System.out.println("----------Esercizio 14 = Stampa ogni elemento preceduto da \"Valore: \".----------");
        stampaOgniElementoPrecedutoDaValore(listaStringhe);
        /**
         * 15. Da array a stream
         * Dato un array String[], convertilo in stream e stampalo in uppercase.
         */
        System.out.println("----------Esercizio 15 = Dato un array String[], convertilo in stream e stampalo in uppercase.----------");
        String[] arrayStringhe = {"Array", "Stringhe", "Uppercase"};
        convertireArrayInStream(arrayStringhe);
    }

    public static List<Integer> numeriPari(List<Integer> listaNumeri) {
        return listaNumeri.stream()
                .filter(n -> n % 2 == 0)
                .toList();
    }

    public static List<Integer> listaLunghezzaParole(List<String> listaStringhe) {
        return listaStringhe.stream()
                .map(s -> s.length())
                .toList();
    }

    public static List<String> listaStringheToUpperCase(List<String> listaStringhe) {
        return listaStringhe.stream()
                .map(String::toUpperCase)
                .toList();
    }

    public static Integer sommaInteriLista(List<Integer> listaNumeri) {
        return listaNumeri.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static long contaQuanteStringheInizianoConA(List<String> listaStringhe) {
        return listaStringhe.stream()
                .filter(s -> s.startsWith("A"))
                .count();
    }

    public static void ordinareListaNumeriOrdineCrescente(List<Integer> listaNumeri) {
        listaNumeri.stream()
                .sorted(Integer::compareTo)
                .forEach(System.out::println);
    }

    public static void ordinaListaStringheOrdineCrescente(List<String> listaStringhe) {
        listaStringhe.stream()
                .map(s -> s.length())
                .sorted(Integer::compareTo)
                .forEach(System.out::println);
    }

    public static List<String> rimuoviDuplicatiListaStringhe(List<String> listaStringhe) {
        return listaStringhe.stream()
                .map(String::toLowerCase)
                .distinct()
                .toList();
    }

    public static Optional<Integer> trovaIlPrimoNumeroMultiploDi7(List<Integer> listaNumeri) {
        return listaNumeri.stream()
                .filter(n -> n % 7 == 0)
                .findFirst();
    }

    public static boolean verificaSeAlmenoUnaStringaLungaDieciCaratteri(List<String> listaStringhe) {
        return listaStringhe.stream()
                .anyMatch(s -> s.length() == 10);
    }

    public static boolean controllaSeTuttiSonoPositivi(List<Integer> listaNumeri) {
        return listaNumeri.stream()
                .allMatch(n -> n > 0);
    }

    public static boolean verificaNessunaStringaVuota(List<String> listaStringa) {
        return listaStringa.stream()
                .noneMatch(s -> s.isEmpty());
    }

    public static List<String> MethodRefStringheToUpperCase(List<String> listaStringhe) {
        return listaStringhe.stream()
                .map(String::toUpperCase)
                .toList();
    }

    public static void stampaOgniElementoPrecedutoDaValore(List<String> listaStringhe) {
        listaStringhe.stream()
                .map(s -> {
                    s = "Valore: " + s;
                    return s;
                })
                .forEach(System.out::println);
        //TODO - Riguardarlo bene -----------------------------------------------------------------------------------------------------------------------------------
    }

    public static void convertireArrayInStream(String[] arrayStringhe){
        Arrays.stream(arrayStringhe)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


}
