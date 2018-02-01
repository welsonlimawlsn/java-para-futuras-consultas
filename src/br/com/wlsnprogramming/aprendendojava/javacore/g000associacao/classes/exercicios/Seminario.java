package br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios;

public class Seminario {

    private String titulo;
    private Aluno[] alunos;
    private Professor professor;
    private Local local;

    public Seminario() {
    }

    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        if (alunos != null) {
            System.out.print("Alunos: ");
            for (Aluno aluno : alunos)
                System.out.print(aluno.getNome() + " ");
        }
        if (professor != null)
            System.out.println("\nProfessor: " + professor.getNome());
        if (local != null)
            System.out.println("Local: " + local);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
