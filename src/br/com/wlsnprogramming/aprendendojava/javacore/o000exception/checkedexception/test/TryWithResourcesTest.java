package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.checkedexception.test;

import br.com.wlsnprogramming.aprendendojava.javacore.o000exception.classes.Leitor1;
import br.com.wlsnprogramming.aprendendojava.javacore.o000exception.classes.Leitor2;

import java.io.*;

public class TryWithResourcesTest {
    public static void main(String[] args) {
        lerArquivoNew();
    }

    public static void lerArquivoOld() {
        Reader reader = null;

        try {
            reader = new BufferedReader(new FileReader("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void lerArquivoNew() {
        try(Leitor1 leitor1 = new Leitor1();
            Leitor2 leitor2 = new Leitor2()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
