package br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes;

public class Vendedor extends Funcionario {

    private double totalVendas;

    public Vendedor(String nome, double salario, double totalVendas) {
        super(nome, salario);
        this.totalVendas = totalVendas;
    }

    @Override
    public void calcularPagamento() {
        salario += totalVendas * .05;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
