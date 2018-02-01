package br.com.wlsnprogramming.aprendendojava.javacore.w000io.test;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File file = new File("arquivo.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {

            bufferedWriter.write("Escrevendo uma mensagem no arquivo");
            bufferedWriter.newLine();
            bufferedWriter.write("Pulando uma linha");
            bufferedWriter.flush();

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
