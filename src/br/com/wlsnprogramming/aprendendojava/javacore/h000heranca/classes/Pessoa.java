package br.com.wlsnprogramming.aprendendojava.javacore.h000heranca.classes;

public class Pessoa {

    protected String nome;
    protected String cpf;
    protected Endereco endereco;

    static {
        System.out.println("Bloco de inicialização estatica de Pessoa");
    }

    {
    System.out.println("Bloco de inicialização 1 de Pessoa");
    }

    {
        System.out.println("Bloco de inicialização 2 de Pessoa");
    }
    public Pessoa(String nome) {
        System.out.println("Dentro do construtor de Pessoa");
        this.nome = nome;
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        if(endereco != null) {
            System.out.println("Endereço: " + endereco.getBairro() + " - " + endereco.getRua());
        }
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
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
