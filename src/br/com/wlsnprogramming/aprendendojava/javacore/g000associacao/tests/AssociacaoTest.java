package br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Aluno;
import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Local;
import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Professor;
import br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios.Seminario;

public class AssociacaoTest {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("Welson", 19);
        Aluno aluno1 = new Aluno("Raissa", 18);

        Seminario seminario = new Seminario("Como ser um baita programador e ficar rico!");
        Professor professor = new Professor("Yoda", "Usar a força para programar");
        Local local = new Local("Rua das Araras", "Mato");

        aluno.setSeminario(seminario);
        aluno1.setSeminario(seminario);

        seminario.setProfessor(professor);
        seminario.setLocal(local);
        seminario.setAlunos(new Aluno[]{aluno, aluno1});

        professor.setSeminarios(new Seminario[]{seminario});

        aluno.imprimir();
        System.out.println("----------------------------------------------------------------");
        seminario.imprimir();
        System.out.println("----------------------------------------------------------------");
        professor.imprimir();

    }
}
