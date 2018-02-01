package br.com.wlsnprogramming.aprendendojava.javacore.y000serializacao.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private transient String senha;
    private static String nomeEscola = "DevDojo";
    private transient Turma turma;

    public Aluno(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Aluno(Long id, String nome, String senha, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.turma = turma;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeUTF(turma.getNome());//Na mesma ordem do readObject
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            turma = new Turma(objectInputStream.readUTF());//Na mesma ordem do writeObject
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static String getNomeEscola() {
        return nomeEscola;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", nomeEscola='" + nomeEscola + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }
}
