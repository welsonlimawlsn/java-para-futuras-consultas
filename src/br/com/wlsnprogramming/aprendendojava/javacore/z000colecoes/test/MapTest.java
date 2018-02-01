package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();//LinkedHashMap mantem a ordem de inserção
        map.put("teklado", "teclado");
        map.put("mauze", "mouse");
        map.put("teklado", "teclado");
        map.put("vc", "você");

        for(String key : map.keySet()) {
            System.out.println(key);
        }

        for(String value : map.values()) {
            System.out.println(value);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
