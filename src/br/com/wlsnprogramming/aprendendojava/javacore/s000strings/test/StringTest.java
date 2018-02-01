package br.com.wlsnprogramming.aprendendojava.javacore.s000strings.test;

public class StringTest {

    public static void main(String[] args) {

        String nome = "Welson";

        String sobrenome = "Teles";


        System.out.println(nome + " " + sobrenome);

        nome = nome.concat(" de Lima");

        System.out.println(nome);

        String teste = "Goku";
        String teste1 = "0123456789";
        String teste2 = "             fddkawdm        ";

        System.out.println(teste.charAt(0));

        System.out.println(teste.equalsIgnoreCase(teste1));
        System.out.println(teste.equals(teste1));
        System.out.println(teste.length());
        System.out.println(teste.replace('o', 'a'));
        System.out.println(teste1.replace('a', 'u'));
        System.out.println(teste.toUpperCase());
        System.out.println(teste.toLowerCase());
        System.out.println(teste.substring(0, 2));
        System.out.println(teste2.trim());

        String valores = "welson-wilson-maria-iraldo-miguel-leticia-gabriel-mariana";
        String[] valoresArray = valores.split("-");

        for(String valor : valoresArray)
            System.out.println(valor.toUpperCase());
    }
}
