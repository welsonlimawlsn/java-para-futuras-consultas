package br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.intefaces.CarroPredicate;
import br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.predicate.FiltrarCarroPorCor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class CarroTest {

    public static <T> List<T> filtrar(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static List<Carro> filtrar(List<Carro> list, CarroPredicate carroPredicate) {
        List<Carro> result = new ArrayList<>();
        for (Carro carro : list) {
            if (carroPredicate.test(carro)) {
                result.add(carro);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Carro> carros = Arrays.asList(
                new Carro("Virtus", "Cinza", 2018),
                new Carro("Passat Variant", "Branco", 2012),
                new Carro("Fusca", "Azul", 1968),
                new Carro("New Civic", "Preto", 2008),
                new Carro("Astra", "Cinza", 2002));

        List<Carro> carrosCinzas = filtrar(carros, new Predicate<Carro>() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("Cinza");
            }
        });

        List<Carro> carrosUltimos10Anos = filtrar(carros, (Carro carro) -> carro.getAno() >= (Calendar.getInstance().get(Calendar.YEAR) - 10));

        List<Carro> carrosBrancos = filtrar(carros, new FiltrarCarroPorCor("Branco"));

        System.out.println(carros);
        System.out.println(carrosCinzas);
        System.out.println(carrosUltimos10Anos);
        System.out.println(carrosBrancos);
    }
}
