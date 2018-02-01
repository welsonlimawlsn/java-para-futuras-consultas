package br.com.wlsnprogramming.aprendendojava.javacore.za000generics.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethodTest {
    public static void main(String[] args) {
        criarArray(new Cachorro());

        List<Gato> gatos = criarList(new Gato(), new Gato());
        System.out.println(gatos);

        List<Animal> animalList = createAnimalList(new Cachorro(), new Gato());
        System.out.println(animalList);
    }

    private static <T> void criarArray(T t) {
        List<T> list = new ArrayList<>();
        list.add(t);
        System.out.println(list);
    }

    private static <T> List<T> criarList(T... elements) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(elements));
        return list;
    }

    private static <T extends Animal> List<T> createAnimalList(T... elements) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(elements));
        return list;
    }
}
