package br.com.wlsnprogramming.aprendendojava.javacore.za000generics.test;

import br.com.wlsnprogramming.aprendendojava.javacore.za000generics.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.za000generics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClassGenericTest {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Gol"));
        carros.add(new Carro("M6"));

        ObjetosAlugaveis<Carro> carrosAlugaveis = new ObjetosAlugaveis<>(carros);

        Carro carroAlugado = carrosAlugaveis.alugar();
        System.out.println("Usando por um mes");
        carrosAlugaveis.devolver(carroAlugado);

        System.out.println("====================================================================");

        List<Computador> computadores = new ArrayList<>();
        computadores.add(new Computador("Alinware"));
        computadores.add(new Computador("Apple"));

        ObjetosAlugaveis<Computador> computadorAlugavel = new ObjetosAlugaveis<>(computadores);
        Computador computadorAlugado = computadorAlugavel.alugar();
        System.out.println("Usando computador por um mes");
        computadorAlugavel.devolver(computadorAlugado);
    }
}

class ObjetosAlugaveis<T> {
    private List<T> objetosDisponiveis;

    public ObjetosAlugaveis(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T alugar(){
        if(objetosDisponiveis.size() > 0) {
            T o = objetosDisponiveis.remove(0);
            System.out.println("Objeto Alugado: " + o);
            return o;
        }
        return null;
    }

    public void devolver(T o) {
        objetosDisponiveis.add(o);
        System.out.println("Objeto Devolvido: " + o);
    }
}
