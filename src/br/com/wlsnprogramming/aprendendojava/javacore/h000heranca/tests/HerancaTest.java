package br.com.wlsnprogramming.aprendendojava.javacore.h000heranca.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.h000heranca.classes.Endereco;
import br.com.wlsnprogramming.aprendendojava.javacore.h000heranca.classes.Funcionario;
import br.com.wlsnprogramming.aprendendojava.javacore.h000heranca.classes.Pessoa;

public class HerancaTest {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Welson");
        pessoa.setCpf("123.456.789-12");

        Endereco endereco = new Endereco();
        endereco.setBairro("Bairro 1");
        endereco.setRua("Rua 25");

        pessoa.setEndereco(endereco);

        pessoa.imprimir();


        Funcionario funcionario = new Funcionario("Wilson");
        funcionario.setCpf("987.654.321-98");
        funcionario.setSalario(15000);

        Endereco endereco1 = new Endereco();
        endereco1.setBairro("Bairro 2");
        endereco1.setRua("Rua 9");

        funcionario.setEndereco(endereco1);

        System.out.println("------------------------------------");

        funcionario.imprimir();
    }
}
