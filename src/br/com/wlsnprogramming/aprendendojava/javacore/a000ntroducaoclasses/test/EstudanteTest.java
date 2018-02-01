package br.com.wlsnprogramming.aprendendojava.javacore.a000ntroducaoclasses.test;

import br.com.wlsnprogramming.aprendendojava.javacore.a000ntroducaoclasses.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante welson = new Estudante();
        welson.nome = "Welson";
        welson.matricula = "123456789";
        welson.idade = 19;

        System.out.println(welson.nome);
        System.out.println(welson.matricula);
        System.out.println(welson.idade);
    }
}
