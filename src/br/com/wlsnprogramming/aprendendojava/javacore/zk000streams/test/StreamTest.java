package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Pessoa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Pessoa> pessoaList = Pessoa.mockPessoas();
        pessoaList.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
        List<String> nomeList = new ArrayList<>();
        pessoaList.forEach(pessoa -> {
            if(pessoa.getIdade() < 25 && nomeList.size() < 3) nomeList.add(pessoa.getNome());
        });
        System.out.println(nomeList);

        List<String> nomesStream = pessoaList.stream()
                .filter(p -> p.getIdade() < 25)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .limit(3)
                .skip(1)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());

        System.out.println(nomesStream);
        long count = pessoaList.stream()
                .filter(p -> p.getIdade() < 25)
                .distinct()
                .map(Pessoa::getNome)
                .count();
        System.out.println(count);

        pessoaList.forEach(System.out::println);

        //Intermediate and Terminal
    }
}
