package br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios;

public class Professor {

    private String nome;
    private String especialidade;
    private Seminario[] seminarios;

    public Professor() {
    }

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        if(seminarios != null) {
            System.out.print("Seminarios: ");
            for (Seminario seminario : seminarios)
                System.out.print(seminario.getTitulo() + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminario[] seminarios) {
        this.seminarios = seminarios;
    }
}
