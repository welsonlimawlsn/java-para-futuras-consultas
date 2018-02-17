package br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ListaNomes {
    private List<String> nomes = new LinkedList<>();

    public synchronized void add(String nome) {
        nomes.add(nome);
    }

    public synchronized void removeFirst() {
        if (nomes.size() > 0) {
            System.out.println(nomes.remove(0) + " removido!");
        }
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        ListaNomes listaNomes = new ListaNomes();
        listaNomes.add("Welson");

        class RemovedorDeNomes extends Thread {
            @Override
            public void run() {
                listaNomes.removeFirst();
            }
        }

        new RemovedorDeNomes().start();
        new RemovedorDeNomes().start();
    }
}
