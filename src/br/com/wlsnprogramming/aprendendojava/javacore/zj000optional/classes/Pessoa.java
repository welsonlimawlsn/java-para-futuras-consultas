package br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes;

import java.util.Optional;

public class Pessoa {

    private String nome;
    private Carro carro;
    private int idade;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Carro carro) {
        this.nome = nome;
        this.carro = carro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Optional<Carro> getCarro() {
        return Optional.ofNullable(carro);
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
