package br.com.wlsnprogramming.aprendendojava.javacore.zi00default.interfaces;

public interface MyList {

    static void sort(){
        System.out.println("Metodo estatico dentro da interface");
    }

    void add();

    default void remove(){
        System.out.println("Detro do remove");
    }
}
