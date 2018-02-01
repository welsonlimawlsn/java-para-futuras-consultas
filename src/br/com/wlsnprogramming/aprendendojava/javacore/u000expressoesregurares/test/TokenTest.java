package br.com.wlsnprogramming.aprendendojava.javacore.u000expressoesregurares.test;

public class TokenTest {
    public static void main(String[] args) {
        String str = "Welson, Maria, Iraldo, Wilson, Miguel, Leticia, Gabriel, Mariana";
        String[] tokens = str.split(",");

        for (String nome : tokens) {
            System.out.println(nome.trim());
        }
    }
}
