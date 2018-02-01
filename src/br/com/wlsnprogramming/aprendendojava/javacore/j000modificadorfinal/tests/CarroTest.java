package br.com.wlsnprogramming.aprendendojava.javacore.j000modificadorfinal.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.j000modificadorfinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRADOR);
        carro.COMPRADOR.setNome("Welson");
        System.out.println(carro.COMPRADOR);
    }
}
