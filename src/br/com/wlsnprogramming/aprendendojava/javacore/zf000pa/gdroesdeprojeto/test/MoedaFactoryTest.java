package br.com.wlsnprogramming.aprendendojava.javacore.zf000pa.gdroesdeprojeto.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.Moeda;
import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.MoedaFactory;
import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.Pais;

public class MoedaFactoryTest {
    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.criarMoeda(Pais.UNITED_STATES);
        System.out.println(moeda.getSimbolo());
    }
}
