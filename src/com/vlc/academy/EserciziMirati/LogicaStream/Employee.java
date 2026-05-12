package com.vlc.academy.EserciziMirati.LogicaStream;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String surname;
    private Integer age;

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    private LocalDate dataNascita;

    public Employee(String name, String surname, Integer age, LocalDate dataNascita) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dataNascita = dataNascita;
    }
    
    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d - %s\n",name, surname, age, dataNascita);
    }
}
