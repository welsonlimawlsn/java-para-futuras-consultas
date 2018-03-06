package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Pessoa;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest6Collectors1 {
    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.mockPessoas();

        System.out.println(pessoas.stream().count());

        System.out.println(pessoas.stream().collect(Collectors.counting()));

        Optional<Pessoa> max = pessoas.stream().max(Comparator.comparing(Pessoa::getSalario));
        System.out.println(max.get());

        Optional<Pessoa> collect = pessoas.stream().collect(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)));
        System.out.println(collect.get());

        Optional<Pessoa> collectMin = pessoas.stream().collect(Collectors.minBy(Comparator.comparing(Pessoa::getSalario)));
        System.out.println(collectMin.get());

        double sum = pessoas.stream().mapToDouble(Pessoa::getSalario).sum();
        System.out.println(sum);

        Double collect1 = pessoas.stream().collect(Collectors.summingDouble(Pessoa::getSalario));
        System.out.println(collect1);

        OptionalDouble average = pessoas.stream().mapToDouble(Pessoa::getSalario).average();
        System.out.println(average);

        Double collect2 = pessoas.stream().collect(Collectors.averagingDouble(Pessoa::getSalario));
        System.out.println(collect2);

        DoubleSummaryStatistics statistics = pessoas.stream().collect(Collectors.summarizingDouble(Pessoa::getSalario));
        System.out.println(statistics);

        String collect3 = pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", "));
        System.out.println(collect3);

    }

}
