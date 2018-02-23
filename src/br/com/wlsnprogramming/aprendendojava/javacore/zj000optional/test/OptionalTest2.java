package br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes.Pessoa;
import br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes.Seguradora;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("Porto Seguros");
        Carro carro = new Carro(seguradora, "BMW");
        Pessoa pessoa = new Pessoa("Welson", carro);
        pessoa.setIdade(19);
        getNomeSeguradora(Optional.ofNullable(pessoa));
        System.out.println(obterNomeSeguradoraComIdade(pessoa,18));

        Map<String, String> map = new HashMap<>();
        System.out.println(Optional.ofNullable(map.get("key")).orElse("Não existe"));
        System.out.println(stringToInt("A"));
    }

    private static Optional<Integer> stringToInt(String number) {
        try {
            return Optional.of(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private static boolean checarNomeSeguradora(Seguradora seguradora, String nome) {
        return seguradora != null && seguradora.getNome().equalsIgnoreCase(nome);
    }

    private static boolean checarNomeSeguradoraOptional(Seguradora seguradora, String nome) {
        Optional<Seguradora> optionalSeguradora = Optional.ofNullable(seguradora);
        optionalSeguradora.filter(s -> s.getNome().equals(nome)).ifPresent(s -> System.out.println(nome));
        return optionalSeguradora.filter(s -> s.getNome().equals(nome)).isPresent();
    }

    private static String obterNomeSeguradoraComIdade(Pessoa pessoa, int idadeMinima) {
        return Optional.ofNullable(pessoa).filter(p -> p.getIdade() >= idadeMinima)
                .flatMap(Pessoa::getCarro).flatMap(Carro::getSeguradora).map(Seguradora::getNome).orElse("Não existe seguradora ou a idade minina não foi atingida");
    }

    private static String getNomeSeguradora(Optional<Pessoa> pessoa) {
        System.out.println(pessoa
                .flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome).orElse("Não existe seguradora"));
        return "";
    }
}
