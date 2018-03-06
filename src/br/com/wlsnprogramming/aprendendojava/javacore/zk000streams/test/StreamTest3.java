package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Pessoa;

import java.util.Comparator;
import java.util.List;

public class StreamTest3 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.mockPessoas();
        System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 2000));
        System.out.println(pessoas.stream().allMatch(p -> p.getIdade() >= 18));
        System.out.println(pessoas.stream().noneMatch(p -> p.getIdade() >= 18));
        pessoas.stream()
                .filter(p->p.getIdade() < 25)
                .findAny()
                .ifPresent(System.out::println);

        pessoas.stream()
                .filter(p -> p.getIdade() > 30)
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .findFirst().ifPresent(System.out::println);
    }
}
