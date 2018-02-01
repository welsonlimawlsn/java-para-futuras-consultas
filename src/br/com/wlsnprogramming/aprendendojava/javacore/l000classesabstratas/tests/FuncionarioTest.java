package br.com.wlsnprogramming.aprendendojava.javacore.l000classesabstratas.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.l000classesabstratas.classes.Gerente;
import br.com.wlsnprogramming.aprendendojava.javacore.l000classesabstratas.classes.Vendedor;

public class FuncionarioTest {
    public static void main(String[] args) {

        Gerente gerente = new Gerente("Anna", "11122-2", 2000);
        gerente.calcularSalario();

        Vendedor vendedor = new Vendedor("Camila", "22114-5", 1200, 5000);
        vendedor.calcularSalario();

        System.out.println(gerente);
        System.out.println(vendedor);
    }
}
