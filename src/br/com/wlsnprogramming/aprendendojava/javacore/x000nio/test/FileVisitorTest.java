package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class AcharTodosOsBkp extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.getFileName().toString().endsWith(".bkp")) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

class PrintDirectories extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File: " + file.getFileName());
        return  FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Directory: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("File: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Directory: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }
}

public class FileVisitorTest {

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("pasta"), new PrintDirectories());
    }
}
