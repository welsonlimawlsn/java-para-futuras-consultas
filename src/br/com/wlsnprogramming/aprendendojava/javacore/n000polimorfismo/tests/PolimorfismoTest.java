package br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes.Gerente;
import br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes.RelatorioPagamento;
import br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes.Vendedor;

public class PolimorfismoTest {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Oswaldo", 5000, 2000);
        Vendedor vendedor = new Vendedor("Yuri", 2000, 20000);

        RelatorioPagamento.relatorioPagamento(gerente);
        System.out.println("--------------------------------------");
        RelatorioPagamento.relatorioPagamento(vendedor);
    }
}
