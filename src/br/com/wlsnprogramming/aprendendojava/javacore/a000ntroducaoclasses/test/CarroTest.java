package br.com.wlsnprogramming.aprendendojava.javacore.a000ntroducaoclasses.test;

import br.com.wlsnprogramming.aprendendojava.javacore.a000ntroducaoclasses.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.modelo = "Fusca";
        carro.placa = "QWE1234";
        carro.velocidadeMaxima = 120f;

        System.out.println(carro.modelo);
        System.out.println(carro.placa);
        System.out.println(carro.velocidadeMaxima);
    }
}
