package br.com.wlsnprogramming.aprendendojava.javacore.l000classesabstratas.classes;

public class Vendedor extends Funcionario {
    private double totalvVendas;

    public Vendedor(double totalvVendas) {
        this.totalvVendas = totalvVendas;
    }

    public Vendedor(String nome, String clt, double salario, double totalvVendas) {
        super(nome, clt, salario);
        this.totalvVendas = totalvVendas;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void calcularSalario() {
        salario += totalvVendas * .05;
    }

    public double getTotalvVendas() {
        return totalvVendas;
    }

    public void setTotalvVendas(double totalvVendas) {
        this.totalvVendas = totalvVendas;
    }

}
