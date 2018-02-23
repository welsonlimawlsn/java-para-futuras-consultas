package br.com.wlsnprogramming.aprendendojava.javacore.zi00default.interfaces;

public interface B extends A {
    default void oi(){
        System.out.println("Dentro do oi de B");
    }
}
