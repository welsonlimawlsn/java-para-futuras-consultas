package br.com.wlsnprogramming.aprendendojava.javacore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Notas {

    public static void main(String[] args) {
        int[] notasDisponiveis = {100, 50, 20, 10, 5, 2, 1};

        try (Scanner scanner = new Scanner(System.in)) {
            int dinheiro = scanner.nextInt();
            Map<Integer, Integer> notas = new HashMap<>();
            notas.put(100, 0);
            notas.put(50, 0);
            notas.put(20, 0);
            notas.put(10, 0);
            notas.put(5, 0);
            notas.put(2, 0);
            notas.put(1, 0);
            for (int nota : notasDisponiveis) {
                while (dinheiro >= nota) {
                    notas.put(nota, notas.get(nota) + 1);
                    dinheiro -= nota;
                }
            }
            for (Map.Entry<Integer, Integer> entry : notas.entrySet()){
                System.out.println("Nota de " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
