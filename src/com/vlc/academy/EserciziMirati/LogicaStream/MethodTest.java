package com.vlc.academy.EserciziMirati.LogicaStream;

import java.util.*;

public class MethodTest {

    static List<String> getDuplicatesIgnoreCase1(List<String> list) {

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equalsIgnoreCase(list.get(j))) {
                    // solo duplicati
                    list1.add(list.get(i));
                }
            }
        }

//        set.stream().toList()
        List<String> list2 = list1.stream().map(String::toLowerCase).toList();
        return new HashSet(list2).stream().toList();
//        List<String> lista = list.stream()
//                .filter((s1,s2) -> s1.equals(s2))
//                .distinct()
//                .toList();
//        lista.forEach(System.out::println);
//        return lista;
    }

    //    static List<String> getDuplicatesIgnoreCase(List<String> list){
//        List<String> list1 = new ArrayList<>();
//        for(String s : list)
//        list1.contains()
//    }
    static List<String> getDuplicatesIgnoreCase(List<String> list) {
        Map<String, Integer> map1 = new HashMap<>();

        // parola , conteggio > 1
        for (String s : list) {
            s = s.toLowerCase();
            boolean contains = map1.keySet().contains(s);
            if (contains) {
                map1.put(s, map1.get(s) + 1); // Popolo la mappa
            } else {
                map1.put(s, 1);
            }
        }
        List<String> list1 = map1.keySet().stream().filter(s -> map1.get(s) > 1).toList();
        System.out.println(list1);
        return list1;
    }


    /**
     * ["Mario", "mario", "Luigi", "LUIGI", "Peach"] -> Input
     * ["Mario", "Luigi", "Peach"] -> Output
     */
//    static List<String> getDuplicatesIgnoreLowerUpperCase(List<String> list){
//        Set<String> set = new HashSet<>();
//
//        list.stream()
//                .filter((s1, s2) -> set.add(s1.equalsIgnoreCase(s1)))
//    }
    public static void main() {
        List<String> stringhe = new ArrayList<>();
        stringhe.add("Ciao");
        stringhe.add("ciao");
        stringhe.add("palo");
        stringhe.add("Ciao");
        stringhe.add("cavo");
        stringhe.add("Palo");
        stringhe.add("cavo");
        stringhe.add("Fabrizio");

        System.out.println(getDuplicatesIgnoreCase(stringhe));


    }
}
