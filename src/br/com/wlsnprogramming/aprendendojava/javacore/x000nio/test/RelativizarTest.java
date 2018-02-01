package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTest {
    public static void main(String[] args) {
        Path directory = Paths.get("/home/welson");
        Path classe = Paths.get("/home/welson/java/Pessoa.java");

        Path pathToClass = directory.relativize(classe);
        System.out.println(pathToClass);
    }
}
