package com.vlc.academy.EserciziMirati.EserciziChat.LivelloBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EsercizIntermedi {
    static void main() {
        /**
         * 16. Mappa parola → lunghezza
         * Dato List<String> words, crea una Map<String,Integer> dove:
         * chiave = parola
         * valore = lunghezza
         */
        System.out.println("----------Esercizio 16 = Mappa parola → lunghezza----------");
        List<String> parole = List.of("Ciao", "Salve", "Buongiorno", "Babbuino", "Calvo", "pippo", "pippo");
        System.out.println(mappareParolaLunghezza(parole));
        /**
         * 17. groupingBy()
         * Raggruppa le stringhe per iniziale.
         * Esempio: ["Mario", "Marco", "Anna"]
         * Output concettuale:
         * M -> [Mario, Marco]
         * A -> [Anna]
         */
        System.out.println("----------Esercizio 17 = Raggruppa le stringhe per iniziale----------");
        System.out.println(raggruppaStringhePerIniziale(parole));
        /**
         * 18. counting()
         * Conta quante volte compare ogni stringa.
         */
        System.out.println("----------Esercizio 18 = Conta quante volte compare ogni stringa----------");
        System.out.println(contaQuanteVolteCompareParola(parole));
        /**
         * 19. groupingBy + counting
         * Conta quante parole iniziano con ogni lettera.
         */
        System.out.println("----------Esercizio 19 = Conta quante volte compare ogni stringa----------");

    }
    public static Map<String, Integer> mappareParolaLunghezza(List<String> listaStringhe){
        return listaStringhe.stream()
                .collect(Collectors.toMap(s -> s, s -> s.length()));
    }
    public static Map<Character, List<String>> raggruppaStringhePerIniziale(List<String> listaStringhe){
        return listaStringhe.stream()
                .collect(groupingBy(s -> s.charAt(0)));
    }
    public static Map<String, Integer> contaQuanteVolteCompareParola(List<String> listaStringhe){

//        Map<String, Integer> mappa = new HashMap<>();
//        Integer contatore = 0;
//        for(String s : listaStringhe){
//            mappa.put(s, contatore+1);
//        }
//        return mappa;
        Map<String, Integer> map = new HashMap<>();
        return listaStringhe.stream()
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
        //TODO - Riguardarlo bene -----------------------------------------------------------------------------------------------------------------------------------
    }

}
