package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Celular;

import java.util.ArrayList;
import java.util.List;

public class ListCelularTest {

    public static void main(String[] args) {
        Celular galaxy = new Celular("Galaxy S7", "123456");
        Celular iphone = new Celular("IPhone", "456712");
        Celular xperia = new Celular("Sony Xperia", "784524");

        List<Celular> celulares = new ArrayList<>();
        celulares.add(galaxy);
        celulares.add(iphone);
        celulares.add(xperia);

        for(Celular celular : celulares) {
            System.out.println(celular);
        }

        Celular celular = new Celular("Galaxy S7", "123456");

        System.out.println(celulares.contains(celular));
    }
}
