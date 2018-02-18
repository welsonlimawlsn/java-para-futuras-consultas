package br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.intefaces;

import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {
    boolean test(Carro carro);
    // (parametro) -> <expressao>
}
