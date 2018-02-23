package br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes;

public class Seguradora {

    private String nome;

    public Seguradora(String nome) {
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
        return "Seguradora{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
