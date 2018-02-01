package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.test;

import br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        estudante.setNome("Welson");
        estudante.setIdate(19);
        estudante.setNotas(5, 7, 6.3);

        estudante.imprimir();
    }
}
