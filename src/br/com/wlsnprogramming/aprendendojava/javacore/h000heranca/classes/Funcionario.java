package br.com.wlsnprogramming.aprendendojava.javacore.h000heranca.classes;

public class Funcionario extends Pessoa {

    private double salario;

    static {
        System.out.println("Bloco de inicialização estatica de Funcionario");
    }

    {
        System.out.println("Bloco de inicialização 1 de Funcionario");
    }

    {
        System.out.println("Bloco de inicialização 2 de Funcionario");
    }

    public Funcionario(String nome) {
        super(nome);
    }

    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Salario: " + salario);
        imprimirRecibo();
    }

    public void imprimirRecibo() {
        System.out.println("Eu " + super.nome + " recebi o pagamento de " + salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
