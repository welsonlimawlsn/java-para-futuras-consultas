package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Welson");
        nomes.add("Wilson");

        List<String> nomes2 = new ArrayList<>();
        nomes2.add("Maria");
        nomes2.add("Iraldo");

        nomes.addAll(nomes2);

        for(int i = 0; i < nomes.size(); i++ ){
            System.out.println(nomes.get(i));
        }

        System.out.println(nomes.remove("Wilson"));

        nomes.clear();

        for(String nome : nomes) {
            System.out.println(nome);
        }
    }
}
