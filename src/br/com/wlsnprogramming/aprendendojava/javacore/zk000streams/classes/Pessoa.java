package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Pessoa {

    private String nome;
    private int idade;
    private double salario;
    private Genero genero;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public Pessoa(String nome, int idade, double salario, Genero genero) {
        this(nome, idade, salario);
        this.genero = genero;
    }

    public static List<Pessoa> mockPessoas() {
        return new ArrayList<>(asList(
                new Pessoa("Welson", 19, 2000, Genero.MASCULINO),
                new Pessoa("Welson", 19, 2000, Genero.MASCULINO),
                new Pessoa("Wilson", 29, 2500, Genero.MASCULINO),
                new Pessoa("Maria", 55, 1700, Genero.FEMININO),
                new Pessoa("Iraldo", 57, 2300, Genero.MASCULINO),
                new Pessoa("Miguel", 1, 0, Genero.MASCULINO),
                new Pessoa("Gabriel", 12, 0, Genero.MASCULINO),
                new Pessoa("Mariana", 10, 0, Genero.FEMININO)
        ));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", salario=" + salario +
                ", genero=" + genero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nome);
    }
}
