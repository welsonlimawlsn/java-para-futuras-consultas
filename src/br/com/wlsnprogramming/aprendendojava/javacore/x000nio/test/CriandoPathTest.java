package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTest {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\welso\\IdeaProjects\\JavaOnline\\file.txt");
        Path path1 = Paths.get("C:\\Users\\welso\\IdeaProjects\\JavaOnline", "file.txt");
        Path path2 = Paths.get("C:", "\\Users\\welso\\IdeaProjects\\JavaOnline", "file.txt");
        Path path3 = Paths.get("C:", "Users", "welso", "IdeaProjects", "JavaOnline", "file.txt");
        System.out.println(path3.toAbsolutePath());
        File file = path3.toFile();
        path3 = file.toPath();

        Path directory = Paths.get("pasta");
        Path directory1 = Paths.get("pasta\\subpasta\\subsubpasta\\file.txt");

        Path pathFile = Paths.get("pasta\\subpasta\\subsubpasta\\file.txt");

        try {
            if(Files.notExists(directory))
                Files.createDirectory(directory);

            if(Files.notExists(directory1.getParent()))
                Files.createDirectories(directory1.getParent());

            if(Files.notExists(pathFile))
                Files.createFile(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("folder2\\file.txt");
        Path target = Paths.get("folder\\copiedFile.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
