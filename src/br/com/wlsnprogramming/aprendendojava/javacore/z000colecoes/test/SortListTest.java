package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Welson de Lima Teles");
        nomes.add("Maria Jesus de Lima Menezes");
        nomes.add("Iraldo Teles de Menezes");
        nomes.add("Wilson de Lima Teles");
        nomes.add("Miguel Machado de Lima");
        nomes.add(0, "Leticia");

        Collections.sort(nomes);

        for(String nome : nomes) {
            System.out.println(nome);
        }
    }
}
