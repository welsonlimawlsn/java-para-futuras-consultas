package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {

    public static void main(String[] args) {
        AviaoSingletonEnum.agendarAssento("1A");
        AviaoSingletonEnum.agendarAssento("1A");
    }
}
