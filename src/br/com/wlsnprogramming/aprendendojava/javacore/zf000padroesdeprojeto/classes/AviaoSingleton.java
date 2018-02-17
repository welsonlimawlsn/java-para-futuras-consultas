package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingleton {

    //Eager Initialization
    //private static final AviaoSingleton INSTANCE = new AviaoSingleton();
    private static AviaoSingleton instance;
    private Set<String> assentosDisponiveis;

    private AviaoSingleton() {
        assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public static AviaoSingleton getInstance() {
        if (instance == null)
            synchronized (AviaoSingleton.class) {
                if (instance == null)
                    instance = new AviaoSingleton();
            }
        return instance;
    }

    public boolean bookAssento(String assento) {
        return assentosDisponiveis.remove(assento);
    }
}
