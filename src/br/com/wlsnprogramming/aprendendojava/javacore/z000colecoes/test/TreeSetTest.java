package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Celular;
import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Produto;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;


class CelularNomeComparator implements Comparator<Celular> {

    @Override
    public int compare(Celular o1, Celular o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}


public class TreeSetTest {
    public static void main(String[] args) {
        Produto nootbookLenovo = new Produto("123", "Nootbook Lenovo", 2000, 1);
        Produto picanha = new Produto("854", "Picanha", 26.4, 0);
        Produto tecladoRazer = new Produto("147", "Teclado Razer", 500, 10);
        Produto samsungGalaxyS8 = new Produto("457", "Samsung Galaxy S8", 3509.89, 0);
        Produto samsungGalaxyS9 = new Produto("457", "Samsung Galaxy S9", 3509.89, 0);

        Celular iphone = new Celular("IPhone X", "789451");

        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new CelularNomeComparator());//Caso a classe não implemetar a interface Comparable, é obrigado criar um Comparator

        celularNavigableSet.add(iphone);//Não implementa Comparable

        for(Celular celular : celularNavigableSet) {
            System.out.println(celular);
        }

        produtoNavigableSet.add(nootbookLenovo);
        produtoNavigableSet.add(picanha);
        produtoNavigableSet.add(tecladoRazer);
        produtoNavigableSet.add(samsungGalaxyS8);
        produtoNavigableSet.add(samsungGalaxyS9);

        for(Produto produto : produtoNavigableSet.descendingSet()) {
            System.out.println(produto);
        }

        System.out.println("=====================================================");

        //lower <
        //flor <=
        //higher >
        //ceiling >=

        System.out.println(produtoNavigableSet.lower(nootbookLenovo));

        System.out.println(produtoNavigableSet.size());
        System.out.println(produtoNavigableSet.pollFirst());//pollLast
        System.out.println(produtoNavigableSet.size());

    }
}
