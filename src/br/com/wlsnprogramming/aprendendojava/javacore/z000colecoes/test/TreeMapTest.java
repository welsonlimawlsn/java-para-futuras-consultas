package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();//Organiza de acordo com a chave, logo a chave tem que implementar a interface Comparable
        map.put("A", "Letra A");
        map.put("B", "Letra B");
        map.put("F", "Letra F");
        map.put("C", "Letra C");
        map.put("D", "Letra D");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println(map.headMap("C", true));
        System.out.println(map.pollFirstEntry());
        System.out.println(map.higherKey("D"));
    }
}
