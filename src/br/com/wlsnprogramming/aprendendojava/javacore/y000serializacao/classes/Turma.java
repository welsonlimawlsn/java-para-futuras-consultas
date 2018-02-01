package br.com.wlsnprogramming.aprendendojava.javacore.y000serializacao.classes;

import java.io.Serializable;

public class Turma implements Serializable {
    private String nome;

    public Turma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
