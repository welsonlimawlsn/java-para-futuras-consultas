package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Produto;

import java.util.*;

class ProdutoNomeComparator implements Comparator<Produto> {
    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class SortProdutosTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("123", "Nootbook Lenovo", 2000));
        produtos.add(new Produto("854", "Picanha", 26.4));
        produtos.add(new Produto("147", "Teclado Razer", 500));
        produtos.add(new Produto("457", "Samsung Galaxy S8", 3509.89));

        Collections.sort(produtos, new ProdutoNomeComparator());

        Produto[] produtosList = new Produto[]{
                new Produto("123", "Nootbook Lenovo", 2000),
                new Produto("854", "Picanha", 26.4),
                new Produto("147", "Teclado Razer", 500),
                new Produto("457", "Samsung Galaxy S8", 3509.89)
        };

        Arrays.sort(produtosList, new ProdutoNomeComparator());

        System.out.println(Arrays.toString(produtosList));

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
