package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvendoPaths {
    public static void main(String[] args) {
        Path directory = Paths.get("home\\welson");
        Path file = Paths.get("dev\\arquivo.txt");

        Path result = directory.resolve(file);

        System.out.println(result);

        Path absolut = Paths.get("/home/welson");
        Path relative = Paths.get("dev");
        Path file2 = Paths.get("file.txt");

        System.out.println();
    }
}
