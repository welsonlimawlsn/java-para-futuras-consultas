package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(8);
        numeros.add(1);

        Collections.sort(numeros);
        //
        System.out.println(Collections.binarySearch(numeros, 3));
        System.out.println(numeros);


        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("123", "Nootbook Lenovo", 2000));
        produtos.add(new Produto("854", "Picanha", 26.4));
        produtos.add(new Produto("147", "Teclado Razer", 500));
        produtos.add(new Produto("457", "Samsung Galaxy S8", 3509.89));

        Collections.sort(produtos, new ProdutoNomeComparator());

        for(Produto produto : produtos) {
            System.out.println(produto);
        }

        Produto produto = new Produto("000", "Rntena", 50);

        System.out.println(Collections.binarySearch(produtos, produto, new ProdutoNomeComparator()));

        produtos.add(-Collections.binarySearch(produtos, produto, new ProdutoNomeComparator())-1, produto);

        for(Produto produto2 : produtos) {
            System.out.println(produto2);
        }
    }
}
