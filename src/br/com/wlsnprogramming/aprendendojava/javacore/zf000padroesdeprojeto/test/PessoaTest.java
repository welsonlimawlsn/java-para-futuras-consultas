package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa.PessoaBuilder("Welson").lastName("Teles").middleName("Lima").username("welsonlimawlsn").build();

        System.out.println(pessoa);
    }
}
