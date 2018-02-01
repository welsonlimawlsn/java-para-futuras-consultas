package br.com.wlsnprogramming.aprendendojava.javacore.i000sobrescrita.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.i000sobrescrita.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Welson de Lima");
        pessoa.setIdade(19);

        System.out.println(pessoa);
    }
}
