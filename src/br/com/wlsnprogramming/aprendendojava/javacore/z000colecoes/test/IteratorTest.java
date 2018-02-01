package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {


        List<Produto> produtos = new LinkedList<>();
        produtos.add(new Produto("123", "Nootbook Lenovo", 2000, 1));
        produtos.add(new Produto("854", "Picanha", 26.4, 0));
        produtos.add(new Produto("147", "Teclado Razer", 500, 10));
        produtos.add(new Produto("457", "Samsung Galaxy S8", 3509.89, 0));

        produtos.removeIf(produto -> produto.getQuantidade() == 0);

        Iterator<Produto> produtoIterator = produtos.iterator();
        while (produtoIterator.hasNext()) {
            if(produtoIterator.next().getQuantidade() == 0) {
                produtoIterator.remove();
            }
        }

        System.out.println(produtos);
    }
}
