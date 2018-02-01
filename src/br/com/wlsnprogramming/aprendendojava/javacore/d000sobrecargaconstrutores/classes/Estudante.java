package br.com.wlsnprogramming.aprendendojava.javacore.d000sobrecargaconstrutores.classes;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class Estudante {

    private String matricula;
    private String nome;
    private double [] notas;
    private Date dataMatricula;

    public Estudante(String matricula, String nome, double[] notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
    }

    public Estudante(String matricula, String nome, double[] notas, Date dataMatricula) {
        this(matricula, nome, notas);
        this.dataMatricula = dataMatricula;
    }

    public Estudante() {

    }

    public void imprimir(){

        System.out.println("///////////////////////////////////");
        System.out.println("Matricula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Notas: " + Arrays.toString(notas));
        System.out.println("Data da matricula: " + (dataMatricula == null ? "Não possui" : DateFormat.getDateTimeInstance().format(dataMatricula)));
        System.out.println("===================================");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
