package br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.intefaces;

import br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {
    boolean test (Carro carro);
    // (parametro) -> <expressao>
}
