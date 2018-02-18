package br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.intefaces.CarroPredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args) {
        // Anonima
        // Funcao
        // Passada por ai
        // Concisa


        // (Carro carro) -> carro.getCor().equals("verde");
        // (String s) -> s.length()
        // (int a, int b) -> {sout(a + b)}

        List<Carro> carros = Arrays.asList(
                new Carro("Virtus", "Cinza", 2018),
                new Carro("Passat Variant", "Branco", 2012),
                new Carro("Fusca", "Azul", 1968),
                new Carro("New Civic", "Preto", 2008),
                new Carro("Astra", "Cinza", 2002));

        CarroPredicate carroPredicate = new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equalsIgnoreCase("cinza");
            }
        };

        CarroPredicate carroPredicate1 = (Carro carro) -> carro.getCor().equalsIgnoreCase("verde");
        Predicate<Carro> predicate = (Carro carro) -> carro.getCor().equalsIgnoreCase("cinza");

        System.out.println(carroPredicate.test(carros.get(0)));
        System.out.println(carroPredicate1.test(carros.get(0)));
        System.out.println(predicate.test(carros.get(0)));

        Runnable runnable = () -> System.out.println("Executando");
        new Thread(runnable).start();
    }
}
