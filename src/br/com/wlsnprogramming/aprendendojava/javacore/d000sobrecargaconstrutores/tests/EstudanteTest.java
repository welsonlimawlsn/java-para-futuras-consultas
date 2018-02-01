package br.com.wlsnprogramming.aprendendojava.javacore.d000sobrecargaconstrutores.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.d000sobrecargaconstrutores.classes.Estudante;

import java.util.Date;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("123456", "Welson", new double[]{5, 9, 7, 4});
        estudante.imprimir();

        Estudante estudante1 = new Estudante("456789", "Wilson", new double[]{8, 6, 7, 7}, new Date());
        estudante1.imprimir();
    }
}
