package com.vlc.academy.esercizimirati.LogicaStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainEmployee {

    public static final LocalDate NOW = LocalDate.now();

    public static void main() {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("paolo", "bira", null, LocalDate.of(1990, 5, 8)));
        list.add(new Employee("sara", "pira", null, LocalDate.of(1996, 5, 8)));
        list.add(new Employee("flavio", "bira", null, LocalDate.of(2006, 5, 8)));

        getEta(list);
        System.out.println(list);


    }
//    public static List<String> returnList(List<Employee> listEmp){
//        String uno = "1";
//        Integer unoInt = null;
//        unoInt = Integer.parseInt(uno);
//        List<String> list = listEmp.stream().map(e -> e.getName()).toList();
//    }


    /**
     * Ricavo l'età di ogni impiegato e la setto per ognuno di essi
     * @param impiegati
     * @return
     */
    public static void getEta(List<Employee> impiegati){
        impiegati.forEach(MainEmployee::setEta);
    }

    private static Employee setEta(Employee e) {
        e.setAge(getEta(NOW, e.getDataNascita()));
        return e;
    }

    /**
     * Questo metodo estrae l'età di una persona a partire dalla data di nascita
     * @param dataOdierna
     * @param dataNascita
     * @return
     */
    private static Integer getEta(LocalDate dataOdierna, LocalDate dataNascita) {
        //Ricavo l'anno
        int anniCalcolati = dataOdierna.getYear() - dataNascita.getYear();
        //ricavo i giorni dell'anno
        int giorniCalcolati = dataOdierna.getDayOfYear() - dataNascita.getDayOfYear();
        //Confronto i giorni per contrrollo
        if(giorniCalcolati < 0){
            anniCalcolati = anniCalcolati -1;
        }
        return anniCalcolati;
    }


}
