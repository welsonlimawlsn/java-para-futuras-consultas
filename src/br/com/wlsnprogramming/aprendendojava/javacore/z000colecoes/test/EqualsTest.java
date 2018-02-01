package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Celular;

public class EqualsTest {
    public static void main(String[] args) {
        String nome = "Welson Teles";
        String nome1 = new String("Welson Teles");

        System.out.println(nome.equals(nome1));

        Celular celular = new Celular("iPhone", "1234");
        Celular celular2 = new Celular("iPhone", "15234");

        System.out.println(celular.equals(celular2));

    }
}
