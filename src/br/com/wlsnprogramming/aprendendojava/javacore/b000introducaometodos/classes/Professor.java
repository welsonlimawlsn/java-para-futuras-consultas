package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes;

public class Professor {

    public String nome;
    public String matricula;
    public String rg;
    public String cpf;

    public Professor(){}

    public Professor(String nome, String matricula, String rg, String cpf){
        this.nome = nome;
        this.matricula = matricula;
        this.rg = rg;
        this.cpf = cpf;
    }

    public void imprimir(){
        System.out.println("Professor:\n" +
                "Nome: " + nome +
                "\nMatricula: " + matricula +
                "\nRG: " + rg +
                "\nCPF: " + cpf);
    }

    public static void alterarNome(Professor professor, String nome){
        professor.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
