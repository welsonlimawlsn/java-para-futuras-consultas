package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Produto;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {

        //ArrayList - get mais rapido
        //LinkedList - remove mais rapido

        Produto nootbookLenovo = new Produto("123", "Nootbook Lenovo", 2000, 1);
        Produto picanha = new Produto("854", "Picanha", 26.4, 0);
        Produto tecladoRazer = new Produto("147", "Teclado Razer", 500, 10);
        Produto samsungGalaxyS8 = new Produto("457", "Samsung Galaxy S8", 3509.89, 0);
        Produto samsungGalaxyS9 = new Produto("457", "Samsung Galaxy S9", 3509.89, 0);

        Set<Produto> produtoSet = new LinkedHashSet<>();//HashSet e o LinkedHashSet que mantem a ordem de inserção
        produtoSet.add(nootbookLenovo);
        produtoSet.add(picanha);
        produtoSet.add(samsungGalaxyS8);
        produtoSet.add(tecladoRazer);
        produtoSet.add(samsungGalaxyS9);

        for(Produto produto : produtoSet ) {
            System.out.println(produto);
        }
    }
}
