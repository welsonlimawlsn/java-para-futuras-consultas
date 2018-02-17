package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes;

public class MoedaFactory {

    public static Moeda criarMoeda(Pais pais) {
        switch (pais) {
            case BRAZIL:
                return new Real();
            case UNITED_STATES:
                return new USDolar();
            default:
                throw new IllegalArgumentException("Não existe esse pais.");
        }
    }
}
