package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();//Objeto tem que implemetar a interface Comparable
        queue.add("C");
        queue.add("D");
        queue.add("A");
        queue.add("B");
        queue.add("F");

        //peek - pega o primeiro elemento, mais não remove
        //poll - pega o primeiro elemento e remove
        System.out.println(queue);
    }
}
