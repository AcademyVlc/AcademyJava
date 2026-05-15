package com.vlc.academy.esercizimirati.EserciziChat.lacune.Biblioteca;

public class MainBiblioteca {
    static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("Rodari");

        try {
            Libro l1 = b1.aggiungiLibro("XYZ679O", "I promessi sposi", "Manzoni", 10);
            Libro l2 = b1.aggiungiLibro("XYZ6791", "I promessi sposi 2", "Manzoni", 1);
//            b1.aggiungiLibro("XYZ6791", "I promessi sposi 2", "Manzoni", 1); Codice già esistente, impossibile inserire un nuovo libro con quel codice
            Libro l3 = b1.aggiungiLibro("XYZ6792", "Shrek", "Marzapane", 0);

            Utente u1 = b1.aggiungiUtente("PSSGFN01", "Stefano");
//            b1.aggiungiUtente("PSSGFN01", "Stefano"); Utente già registrato con quel codice fiscale
//            Utente u2 = b1.aggiungiUtente("CV78TY9", "Fausto"); // Codice Fiscale errato, devono essere 8 caratteri

//            b1.prestaLibro(null, u1.getCodiceFiscale()); // Libro non trovato
//            b1.prestaLibro(l1.getCodice(), null); // Utente non trovato
//            b1.prestaLibro(l3.getCodice(), u1.getCodiceFiscale()); // Copie Libro Terminate
            System.out.println(STR."Copie del libro prima del prestito: \{l1} sono \{l1.getCopie()}"); // 10 copie
            b1.prestaLibro(l1.getCodice(), u1.getCodiceFiscale(), 2); // Il prestito fa diminuire le copie
            System.out.println(STR."Copie del libro dopo il prestito: \{l1} sono \{l1.getCopie()}"); // 8 copie -> Perchè ne richiede 2
            System.out.println(b1.libriDisponibili()); // [I promessi sposi, I promessi sposi 2] -> Shrek non ha copie disponibili quindi non compare

            System.out.println(b1.prestitiUtente("PSSGFN01"));
        } catch (CodiceDuplicato | UtenteDuplicato | CodiceFiscaleSbagliato e) {
            System.out.println(e.getMessage());
        }
    }

}
