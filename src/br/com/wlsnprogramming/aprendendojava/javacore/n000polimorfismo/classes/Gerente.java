package br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes;

public class Gerente extends Funcionario {

    private double pnl;

    public Gerente(String nome, double salario, double pnl) {
        super(nome, salario);
        this.pnl = pnl;
    }

    @Override
    public void calcularPagamento() {
        salario += pnl;
    }

    public double getPnl() {
        return pnl;
    }

    public void setPnl(double pnl) {
        this.pnl = pnl;
    }
}
