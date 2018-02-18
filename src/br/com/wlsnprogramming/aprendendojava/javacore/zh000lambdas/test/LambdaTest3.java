package br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.classes.CarComparator;
import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.intefaces.TriFunction;

import java.util.*;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest3 {
    public static void main(String[] args) {
        List<Carro> carros = asList(
                new Carro("Virtus", "Cinza", 2018),
                new Carro("Passat Variant", "Branco", 2012),
                new Carro("Fusca", "Azul", 1968),
                new Carro("New Civic", "Preto", 2008),
                new Carro("Astra", "Cinza", 2002));

        forEach(carros, carro -> System.out.println(carro));

        forEach(carros, System.out::println);

        Collections.sort(carros, (carro1, carro2) -> carro1.getCor().compareTo(carro2.getCor()));

        //////////////////////////////////////////////////////////////////////////////////////////////

        //Reference to a static method
        Collections.sort(carros, CarComparator::compareByColor);

        System.out.println("================================================================");

        forEach(carros, System.out::println);

        //Reference to an instance method of a particular object

        Collections.sort(carros, new CarComparator()::compareByName);

        System.out.println("================================================================");

        forEach(carros, System.out::println);
        System.out.println("================================================================");

        //Reference to an instance method of an arbitrary object of a particular type

        List<String> nomes = asList("Welson", "Maria", "Iraldo", "Wilson", "Miguel", "Leticia", "Gabriel", "Mariana");

        nomes.sort((s1, s2) -> s1.compareTo(s2));

        nomes.sort(String::compareTo);

        carros.sort(Carro::compareByYear);

        System.out.println(nomes);
        System.out.println(carros);

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = Integer::parseInt;

        BiPredicate<List<String>, String> contemIsso = (List<String> list, String string) -> list.contains(string);
        BiPredicate<List<String>, String> contemIsso2 = List::contains;

        //Reference to a constructor

        Supplier<CarComparator> carComparatorSupplier = CarComparator::new;

        BiFunction<String, Integer, Carro> carro = Carro::new;
        System.out.println(carro.apply("Verde", 2010));

        TriFunction<String, String, Integer, Carro> carroTriFunction = Carro::new;
        System.out.println(carroTriFunction.apply("Polo", "Branco", 2018));

    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
