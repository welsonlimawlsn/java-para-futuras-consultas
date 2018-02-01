package br.com.wlsnprogramming.aprendendojava.javacore.y000serializacao.test;

import br.com.wlsnprogramming.aprendendojava.javacore.y000serializacao.classes.Aluno;
import br.com.wlsnprogramming.aprendendojava.javacore.y000serializacao.classes.Turma;

import java.io.*;

public class SerializacaoTest {
    public static void main(String[] args) {
        gravadorObjeto(new Aluno(2L, "Welson de Lima Teles", "123456798", new Turma("C")), "welson.ser");
        System.out.println(leitorObjeto("welson.ser"));
    }

    private static void gravadorObjeto(Serializable object, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object leitorObjeto(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
