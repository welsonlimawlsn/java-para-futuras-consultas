package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes;

import java.util.Arrays;

public class Estudante {

    private String nome;
    private int idade;
    private double[] notas;
    private boolean aprovado;

    private double media() {
        if (notas == null) {
            return -1;
        }
        double soma = 0;
        for (double nota : notas)
            soma += nota;
        return soma / notas.length;
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Notas: " + Arrays.toString(notas));
        System.out.println("Média: " + media());
        if (isAprovado()) {
            System.out.println("Aprovado: SIM");
        } else {
            System.out.println("Aprovado: NÃO");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdate(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        } else {
            System.err.println("Você não pode colocar uma idade negativa!");
        }
    }

    public void setNotas(double... notas) {
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double[] getNotas() {
        return notas;
    }

    public boolean isAprovado() {
        setAprovado();
        return aprovado;
    }

    private void setAprovado() {
        if(media() == -1){
            System.err.println("Esse aluno não possui notas!");
            aprovado = false;
        } else if(media() > 6){
            aprovado = true;
        } else {
            aprovado = false;
        }
    }

}
