package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {
    public static void main(String[] args) {

        String diretorioProjeto = "JavaOnline\\home\\welson\\dev";
        String arquivoTxt = "..\\..\\arquivo.txt";

        Path path = Paths.get(diretorioProjeto, arquivoTxt);

        System.out.println(path);
        System.out.println(path.normalize());

        Path path1 = Paths.get("a/./s/./x");
        System.out.println(path1);
        System.out.println(path1.normalize());
    }
}
