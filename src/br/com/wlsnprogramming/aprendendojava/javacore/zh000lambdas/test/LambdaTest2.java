package br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.classes.Carro;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest2 {
    public static void main(String[] args) {
        forEach(asList("Welson", "Maria", "Iraldo", "Leticia", "Wilson"), new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        forEach(asList("Welson", "Maria", "Iraldo", "Leticia", "Wilson"), (String string) -> System.out.println(string));

        List<Integer> listSize = map(asList("Welson", "Maria", "Iraldo", "Leticia", "Wilson"), new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

        System.out.println(listSize);

        List<Integer> listSize2 = map(asList("Welson", "Maria", "Iraldo", "Leticia", "Wilson"), (String s) -> s.length());

        System.out.println(listSize2);

        List<Carro> carros = Arrays.asList(
                new Carro("Virtus", "Cinza", 2018),
                new Carro("Passat Variant", "Branco", 2012),
                new Carro("Fusca", "Azul", 1968),
                new Carro("New Civic", "Preto", 2008),
                new Carro("Astra", "Cinza", 2002));

        carros.forEach((Carro carro) -> System.out.println(carro.getNome()));

        List<String> coresDisponiveis = map(carros, (Carro carro) -> carro.getCor());
        List<String> modelosDisponiveis = map(carros, Carro::getNome);
        System.out.println(coresDisponiveis);
        System.out.println(modelosDisponiveis);

//        IntPredicate
//        DoublePredicate
//        LongPredicate

        IntPredicate impar = (int i) -> i % 2 == 1;
        Predicate<Integer> numeroPar = (Integer integer) -> integer % 2 == 0;
        System.out.println(impar.test(26));

        System.out.println(numeroPar.test(26));

        Callable<Integer> callable = () -> 100;
        PrivilegedAction<Integer> privilegedAction = () -> 100;

        Predicate<String> cor = (String string) -> coresDisponiveis.add(string);
        cor.test("Amarelo");

        Consumer<String> cor2 = (String string) -> coresDisponiveis.add(string);
        cor2.accept("Vermelho");

        System.out.println(coresDisponiveis);

        Supplier<String> supplier = () -> "Olá";
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
