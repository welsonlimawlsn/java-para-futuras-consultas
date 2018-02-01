package br.com.wlsnprogramming.aprendendojava.javacore.a000ntroducaoclasses.test;

import br.com.wlsnprogramming.aprendendojava.javacore.a000ntroducaoclasses.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.cpf = "123.456.789-12";
        professor.matricula = "123456";
        professor.nome = "Jurandir";
        professor.rg = "1234567";
    }
}
