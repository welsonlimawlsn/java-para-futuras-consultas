package br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.intefaces;

@FunctionalInterface
public interface TriFunction<A, B, C, D> {

    D apply(A a, B b, C c);
}
