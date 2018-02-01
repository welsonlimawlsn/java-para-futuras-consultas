package br.com.wlsnprogramming.aprendendojava.javacore.c000sobrecargametodos.classes;

import br.com.wlsnprogramming.aprendendojava.util.CPF;

public class Funcionario {

    private String nome;
    private String cpf;
    private double salario;
    private String rg;

    public Funcionario(){}

    public Funcionario(String nome, String cpf, double salario) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
    }

    public Funcionario(String nome, String cpf, String rg, double salario){
        this(nome, cpf, salario);
        setRg(rg);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(CPF.isValid(cpf))
            this.cpf = cpf;
        else
            System.err.println("CPF invalido");
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario >= 0)
            this.salario = salario;
        else
            System.err.println("Salário não pode ser negativo");
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void imprimir(){
        System.out.println("//////////////////////////////");
        System.out.println("Nome: " + nome);
        System.out.println("Salario: " + salario);
        System.out.println("CPF: " + cpf);
        System.out.println("==============================");
    }
}
