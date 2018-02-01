package br.com.wlsnprogramming.aprendendojava.javacore.k000enum.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.k000enum.classes.Cliente;
import br.com.wlsnprogramming.aprendendojava.javacore.k000enum.classes.TipoCliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Wilson", TipoCliente.PESSOA_JURIDICA, Cliente.TipoPagamento.AVISTA);
        System.out.println(cliente);
    }
}
