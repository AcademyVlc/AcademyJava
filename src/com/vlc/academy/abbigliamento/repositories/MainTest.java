package com.vlc.academy.abbigliamento.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        Modello mo1 = new Modello("Canotta", 6, 0.5);
        Materiale ma1 = new Materiale("Cotone", 3);
        Colore co1 = new Colore("Rosa");
        Capo capo1 = new Capo(mo1, ma1, co1); //Canotta cotone rosa

        Modello mo2 = new Modello("T-Shirt", 6, 1);
        Materiale ma2 = new Materiale("Poliestere", 3);
        Colore co2 = new Colore("Blu");
        Capo capo2 = new Capo(mo2, ma2, co2); //T-shirt pelle blu

        Modello mo3 = new Modello("Giacca", 6, 0.3);
        Materiale ma3 = new Materiale("Pelle", 3);
        Colore co3 = new Colore("Nera");
        Capo capo3 = new Capo(mo3, ma3, co3); // Giacca pelle nera

        Modello mo4 = new Modello("Giacca", 6, 0.3);
        Materiale ma4 = new Materiale("Pelle", 3);
        Colore co4 = new Colore("Marrone Beige");
        Capo capo4 = new Capo(mo4, ma4, co4); // Giacca pelle marrone beige

        Collezione collezione1 = new Collezione(); // Creo la collezione

        collezione1.add(capo1); // aggiungo i capi alla collezione
        collezione1.add(capo2);
        collezione1.add(capo3);
        collezione1.add(capo4);

        System.out.println("Di seguito i capi della collezione");
        collezione1.mostraTuttiCapi(); // stampa la collezione
        System.out.println("------------------------------");
        System.out.println("\nTrova un capo dato il modello (modello 1)");
        System.out.println(collezione1.trova(mo1));
        System.out.println("\nTrova un capo dato il materiale (materiale 2)");
        System.out.println(collezione1.trova(ma2));
        System.out.println("\nTrova un capo dato il colore (colore 3)");
        System.out.println(collezione1.trova(co3));
        System.out.println("\nTrova un capo dato il materiale (materiale 4)");
        System.out.println(collezione1.trova(ma4));
        System.out.println("--------------------------------------------------------");
        System.out.println(STR."Quantità del tessuto1: \{mo1.getQuantitaTessuto()}"); // 0.25
        System.out.println(STR."Nome del modello1: \{mo1.getNome()}"); // Canotta
        System.out.println(STR."Costo fisso del modello1: \{mo1.getCostoFisso()}"); // 6.0
        System.out.println(STR."Prezzo del capo1: \{capo1.prezzo()}"); // 6.75
        System.out.println("--------------------------------------------------------");
        // TODO - IOException del file -> Try catch
        Abbigliamento a = new Abbigliamento();
        try {
            a.leggiFile("src/com/vlc/academy/abbigliamento/file/abbigliamento.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
