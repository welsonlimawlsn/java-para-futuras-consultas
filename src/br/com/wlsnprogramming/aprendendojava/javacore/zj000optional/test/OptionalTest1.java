package br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.test;

import java.util.Optional;

public class OptionalTest1 {
    private String nome;

    public static void main(String[] args) {
        OptionalTest1 optionalTest1 = new OptionalTest1();
        Optional<String> stringOptional1 = Optional.of("Welson");
        Optional<String> stringOptional2 = Optional.empty();
        Optional<String> stringOptional3 = Optional.ofNullable(optionalTest1.nome);

        System.out.println(stringOptional1);
        System.out.println(stringOptional2);
        System.out.println(stringOptional3);

        System.out.println(stringOptional1.get());
        System.out.println(stringOptional1.orElse("[Não informado!]"));
        if (optionalTest1.nome != null)
            System.out.println(optionalTest1.nome.toUpperCase());
    }
}
