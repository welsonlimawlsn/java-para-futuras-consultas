package br.com.wlsnprogramming.aprendendojava.javacore.l000classesabstratas.classes;

public abstract class Pessoa {

    protected String nome;

    public abstract void imprimir();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
