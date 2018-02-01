package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.checkedexception.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {
        try {
            criarArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void criarArquivo() throws IOException {
        File file = new File("Teste.txt");
        System.out.println("Arquivo criado: " + file.createNewFile());
        System.out.println("Arquivo criado com sucesso!");
    }

    public static void criarArquivo2() throws IOException {
        try {
            File file = new File("Teste.txt");
            System.out.println("Arquivo criado: " + file.createNewFile());
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void abrirArquivo() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Execuntando a leitura do arquivo");
            System.out.println("Escrevendo no arquivo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fechando arquico");
        }
    }
}
