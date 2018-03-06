package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes.Pessoa;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest4Reduce {
    public static void main(String[] args) {
        Optional<Integer> reduce = getStream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        Integer integer = getStream().reduce(0, (x, y) -> x + y);
        System.out.println(integer);

        Optional<Integer> integerOptional = getStream().reduce(Integer::sum);
        System.out.println(integerOptional.get());

        Integer multi = getStream().reduce(1, (x, y) -> x * y);
        System.out.println(multi);

        Optional<Integer> maxFeio = getStream().reduce((x, y) -> x >= y ? x : y);
        System.out.println(maxFeio.get());

        Optional<Integer> maxBonito = getStream().reduce(Integer::max);
        System.out.println(maxBonito.get());

        Stream<Pessoa> pessoaStream = Pessoa.mockPessoas().stream();
        Optional<Double> somaSalario = pessoaStream.filter(p -> p.getSalario() > 2000)
                .map(Pessoa::getSalario).reduce(Double::sum);
        System.out.println(somaSalario.get());

        double somaSalarioDouble = Pessoa.mockPessoas().stream()
                .filter(pessoa -> pessoa.getSalario() > 2000)
                .mapToDouble(Pessoa::getSalario).sum();
        System.out.println(somaSalarioDouble);

        DoubleStream doubleStream = Pessoa.mockPessoas().stream()
                .filter(pessoa -> pessoa.getSalario() > 2000)
                .mapToDouble(Pessoa::getSalario);

        Stream<Double> boxed = doubleStream.boxed();


    }

    private static Stream<Integer> getStream() {
        return asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
    }
}
