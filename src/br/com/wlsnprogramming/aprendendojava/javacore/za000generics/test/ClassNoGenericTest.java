package br.com.wlsnprogramming.aprendendojava.javacore.za000generics.test;

import br.com.wlsnprogramming.aprendendojava.javacore.za000generics.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.za000generics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClassNoGenericTest {
    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.alugarCarro();
        System.out.println("Usando o carro por um mes");
        carroAlugavel.devolverCarro(carroAlugado);

        System.out.println("====================================================================");

        ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
        Computador computadorAlugado = computadorAlugavel.alugarComputador();
        System.out.println("Usando computador por um mes");
        computadorAlugavel.devolverComputador(computadorAlugado);
    }
}

class CarroAlugavel {
    private List<Carro> carrosDisponiveis = new ArrayList<>();

    {
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("M6"));
    }

    Carro alugarCarro() {
        if (carrosDisponiveis.size() > 0) {
            Carro carro = carrosDisponiveis.remove(0);
            System.out.println("Carro Alugado: " + carro);
            return carro;
        }
        return null;
    }

    void devolverCarro(Carro carro) {
        carrosDisponiveis.add(carro);
        System.out.println("Carro devolvido: " + carro);
    }
}

class ComputadorAlugavel {
    private List<Computador> computadoresDisponiveis = new ArrayList<>();

    {
        computadoresDisponiveis.add(new Computador("Alinware"));
        computadoresDisponiveis.add(new Computador("Apple"));
    }

    Computador alugarComputador() {
        if (computadoresDisponiveis.size() > 0) {
            Computador computador = computadoresDisponiveis.remove(0);
            System.out.println("Computador Alugado: " + computador);
            return computador;
        }
        return null;
    }

    void devolverComputador(Computador computador) {
        computadoresDisponiveis.add(computador);
        System.out.println("Computador devolvido: " + computador);
    }
}