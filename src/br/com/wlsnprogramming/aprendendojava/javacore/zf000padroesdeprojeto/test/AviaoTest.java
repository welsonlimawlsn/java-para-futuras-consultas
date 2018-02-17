package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.Aviao;

public class AviaoTest {
    public static void main(String[] args) {

        agendarAssento("1A");
        agendarAssento("1A");

    }

    private static void agendarAssento(String assento) {
        Aviao a = new Aviao();
        System.out.println(a.bookAssento(assento));
    }
}
