package br.com.wlsnprogramming.aprendendojava.javacore.c000sobrecargametodos.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.c000sobrecargametodos.classes.Funcionario;

public class FuncionarioTest {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Chica da Silva", "629.996.949-03", 4500);
        funcionario.imprimir();

        Funcionario funcionario1 = new Funcionario("Welson Teles", "064.602.231-81", "123456", 4500);
        funcionario1.imprimir();
    }
}
