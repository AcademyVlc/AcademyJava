package com.vlc.academy.testacademyPirastruStefano;

import java.time.LocalDate;

public class Event {
    private String nome;
    private LocalDate data;
    private String luogo;
    private int numeroBigliettiDisponibili;

    public Event(String nome, LocalDate data, String luogo, int numeroBigliettiDisponibili) {
        this.nome = nome;
        this.data = data;
        this.luogo = luogo;
        this.numeroBigliettiDisponibili = numeroBigliettiDisponibili;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public int getNumeroBigliettiDisponibili() {
        return numeroBigliettiDisponibili;
    }

    public void setNumeroBigliettiDisponibili(int numero) {
        this.numeroBigliettiDisponibili = numero;
    }

    @Override
    public String toString() {
        return STR."Evento nome: \{nome} -> Data: \{data} -> Luogo: \{luogo} -> Numero biglietti ancora disponibili: \{numeroBigliettiDisponibili}";
    }
}
