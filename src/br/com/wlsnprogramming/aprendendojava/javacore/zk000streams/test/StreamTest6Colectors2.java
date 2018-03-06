package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Genero;
import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Maioridade;
import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Pessoa;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest6Colectors2 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.mockPessoas();

        Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();

        List<Pessoa> masculinos = new ArrayList<>();
        List<Pessoa> femininos = new ArrayList<>();

        for(Pessoa pessoa : pessoas) {
            switch (pessoa.getGenero()) {
                case FEMININO:
                    femininos.add(pessoa);
                    break;
                case MASCULINO:
                    masculinos.add(pessoa);
            }
        }
        generoListMap.put(Genero.FEMININO, femininos);
        generoListMap.put(Genero.MASCULINO, masculinos);

        System.out.println(generoListMap);

        // AGRUPAMENTO POR GENERO
        Map<Genero, List<Pessoa>> generoListMap1 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero));

        System.out.println(generoListMap1);

        // AGRUPAMENTO POR MAIORIDADE

        Map<Maioridade, List<Pessoa>> collect = pessoas.stream()
                .collect(Collectors.groupingBy(p -> p.getIdade() < 18 ? Maioridade.MENOR : Maioridade.ADULTO));

        System.out.println(collect);

        // AGRUPAMENTO POR GENERO E MARIORIDADE

        Map<Genero, Map<Maioridade, List<Pessoa>>> collect1 = pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getGenero,
                        Collectors.groupingBy(p -> p.getIdade() < 18 ? Maioridade.MENOR : Maioridade.ADULTO)));

        System.out.println(collect1);

        // AGRUPANDO POR GENERO E CONTANDO

        Map<Genero, Long> collect2 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.counting()));

        System.out.println(collect2);

        // AGRUPANDO POR GENERO E MAIOR SALARIO

        Map<Genero, Optional<Pessoa>> collect3 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero,
                Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));

        System.out.println(collect3);

        // AGRUPANDO POR GENERO E MAIOR SALARIO SEM OPTIONAL

        Map<Genero, Pessoa> collect4 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)), Optional::get)));

        System.out.println(collect4);

        // AGRUPANDO POR GENERO E ESTATISTICAS

        Map<Genero, DoubleSummaryStatistics> collect5 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero,
                Collectors.summarizingDouble(Pessoa::getSalario)));

        System.out.println(collect5);

        // AGRUPANDO POR GENERO E MARIORIDADE
        Map<Genero, Set<Maioridade>> collect6 = pessoas.stream().collect(
                Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.mapping(pessoa -> pessoa.getIdade() < 18 ? Maioridade.MENOR : Maioridade.ADULTO, Collectors.toSet()))
        );

        System.out.println(collect6);

        Map<Genero, Set<Maioridade>> collect7 = pessoas.stream().collect(
                Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.mapping(pessoa -> pessoa.getIdade() < 18 ? Maioridade.MENOR : Maioridade.ADULTO, Collectors.toCollection(LinkedHashSet::new)))
        );
        System.out.println(collect7);
    }
}
