package br.com.wlsnprogramming.aprendendojava.javacore.m000intefaces.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.m000intefaces.classes.Produto;

public class ProdutoTest {
    public static void main(String[] args) {
        Produto produto = new Produto("Notebook", 4, 3000);
        produto.calcularFrete();
        produto.calcularImposto();
        System.out.println(produto);
    }
}
