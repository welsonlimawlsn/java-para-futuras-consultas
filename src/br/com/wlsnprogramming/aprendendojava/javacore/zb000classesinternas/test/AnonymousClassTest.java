package br.com.wlsnprogramming.aprendendojava.javacore.zb000classesinternas.test;

import br.com.wlsnprogramming.aprendendojava.javacore.za000generics.classes.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Animal {
    public void andar(){
        System.out.println("Animal andando");
    }
}

public class AnonymousClassTest {
    public static void main(String[] args) {
        Animal animal = new Animal(){
            @Override
            public void andar() {
                System.out.println("Andando rapido");
            }
        };
        animal.andar();

        List<Carro> carroList = new ArrayList<>();
        carroList.add(new Carro("BMW"));
        carroList.add(new Carro("Audi"));

        Collections.sort(carroList, new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        System.out.println(carroList);
    }
}
