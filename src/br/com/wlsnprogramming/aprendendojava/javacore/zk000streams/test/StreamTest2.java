package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest2 {
    public static void main(String[] args) {
        List<List<String>> nomes = new ArrayList<>();
        nomes.add(asList("DevDojo", "Valeu por aumentar a letra!"));
        nomes.add(asList("William", "Por que voce demorou 180 aulas para isso?"));

        Stream<List<String>> stream = nomes.stream();
        Stream<String> stringStream = nomes.stream().flatMap(Collection::stream);
        List<String> collect = nomes.stream().flatMap(Collection::stream).collect(Collectors.toList());

        stringStream.forEach(System.out::println);
        collect.forEach(System.out::println);

        System.out.println(nomes);

        List<String> nome = asList("Welson", "Lima");
        String[] split = nome.get(0).split("");
        System.out.println(Arrays.toString(split));

        List<String> collect1 = nome.stream().map(p -> p.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
