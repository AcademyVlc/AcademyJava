package com.vlc.academy.esercizimirati.EserciziChat.lacune.Palestre;

import java.util.ArrayList;
import java.util.List;

public class Palestra {
    private String nome;
    private String citta;
    private List<Cliente> clienti = new ArrayList<>();

    public Palestra(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void aggiungiCliente(Cliente cliente){
        clienti.add(cliente);
    }

    public List<Cliente> clientiPalestra(){
        return clienti;
    }

    @Override
    public String toString() {
        return STR."\{nome} con sede a \{citta}";
    }
}
