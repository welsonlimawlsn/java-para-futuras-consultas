package br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios;

public class Aluno {

    private String nome;
    private int idade;
    private Seminario seminario;

    public Aluno() {
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        if (seminario != null)
            System.out.println("Seminario: " + seminario.getTitulo());
        else
            System.out.println("Aluno não está inscrito em nenhum seminário");
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

    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }
}
