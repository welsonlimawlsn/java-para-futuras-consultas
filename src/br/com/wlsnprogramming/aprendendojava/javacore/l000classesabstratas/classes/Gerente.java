package br.com.wlsnprogramming.aprendendojava.javacore.l000classesabstratas.classes;

public class Gerente extends Funcionario {

    public Gerente() {
    }

    public Gerente(String nome, String clt, double salario) {
        super(nome, clt, salario);
    }

    @Override
    public void calcularSalario() {
        salario += salario * 0.2;
    }
}
