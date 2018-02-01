package br.com.wlsnprogramming.aprendendojava.javacore.w000io.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
    public static void main(String[] args) {
        File file = new File("C:\\aequivos_criados_com_java\\arquivo.txt");
        try (FileWriter fileWriter = new FileWriter(file, true);
             FileReader fileReader = new FileReader(file)) {
            fileWriter.write("Escrevendo uma mensagem no arquivo!\nE pulando uma linha2");
            fileWriter.flush();

            char[] in = new char[500];
            int size = fileReader.read(in);
            System.out.println("Tamanho: " + size);

            for (char c : in) {
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
