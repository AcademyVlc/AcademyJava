package com.vlc.academy.jobapplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Skill {
    private String nome;
    private List<Position> posizioni = new ArrayList<>();

    public Skill(String nome) {
        this.nome = nome;
    }

    public void addPosition(Position position){
        posizioni.add(position);
    }

    public String getNome() {
        return nome;
    }

    public List<Position> getPosizioni() {
        return posizioni.stream()
        .sorted(Comparator.comparing(Position::getNome))
        .toList();
    }
}
