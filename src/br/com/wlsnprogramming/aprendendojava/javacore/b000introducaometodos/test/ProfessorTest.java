package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.test;

import br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {

        Professor[] professores = {
                new Professor("Marcos","123456","11122","123.465.789-12"),
                new Professor("Wilson", "978654", "789456", "978.654.321-98")
        };

        for(Professor professor : professores){
            professor.imprimir();
            System.out.println("=============================================================");
        }

        Professor.alterarNome(professores[1], "Welson");
        professores[1].imprimir();

    }
}
