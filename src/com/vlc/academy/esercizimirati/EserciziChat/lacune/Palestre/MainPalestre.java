package com.vlc.academy.esercizimirati.EserciziChat.lacune.Palestre;

public class MainPalestre {
    static void main() {
        try {
            CatenaPalestre catenaPalestra1 = new CatenaPalestre("Dimagrimondo");
            Palestra palestra1 = catenaPalestra1.aggiungiPalestra("Dimagri1", "Torino");
            Palestra palestra2 = catenaPalestra1.aggiungiPalestra("Dimagri2", "Milano");
            Palestra palestra3 = catenaPalestra1.aggiungiPalestra("Dimagri3", "Roma");
//            Palestra palestra1= catenaPalestra1.aggiungiPalestra(null, "Roma"); // Eccezione Output: Tutti i campi sono obbligatori

            Cliente cliente1 = catenaPalestra1.registraCliente("PSS01", "Stefano", 25);
            Cliente cliente2 = catenaPalestra1.registraCliente("PSS02", "Gaia", 23);
            Cliente cliente3 = catenaPalestra1.registraCliente("PSS03", "Franco", 43);
            Cliente cliente4 = catenaPalestra1.registraCliente("PSS04", "Franco", 60);
//            Cliente cliente3 = catenaPalestra1.registraCliente("PSS01", "Stefano", 25); // Eccezione Output: Utente già registrato, il codice è unico

            Abbonamento abbonamento1 = catenaPalestra1.creaAbbonamento(cliente1.getCodice(), palestra1.getNome(), TipoAbbonamento.BASE, 35);
            Abbonamento abbonamento2 = catenaPalestra1.creaAbbonamento(cliente2.getCodice(), palestra1.getNome(), TipoAbbonamento.PREMIUM, 50);
            Abbonamento abbonamento3 = catenaPalestra1.creaAbbonamento(cliente3.getCodice(), palestra1.getNome(), TipoAbbonamento.VIP, 80);
            Abbonamento abbonamento4 = catenaPalestra1.creaAbbonamento(cliente4.getCodice(), palestra1.getNome(), TipoAbbonamento.VIP, 80);
            System.out.println("Lista dei clienti per palestra: ");
            System.out.println(catenaPalestra1.clientiPerPalestra(palestra1.getNome()));
            System.out.println(STR."\nIncasso totale della palestra \{palestra1} equivalente a \{catenaPalestra1.incassoMensileTotale(palestra1)} euro");
            System.out.println(catenaPalestra1.clientiRaggruppatiPerTipoAbbonamento());



        } catch (TuttiCampiObbligatori | UtenteDuplicato e) {
            System.out.println(e.getMessage());
        }
    }
}
