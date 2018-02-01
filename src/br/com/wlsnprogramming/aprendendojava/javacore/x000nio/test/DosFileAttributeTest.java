package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeTest {
    public static void main(String[] args) {
        Path path = Paths.get("folder2\\test.txt");
        try {
            if(Files.notExists(path)) {
                Files.createFile(path);
            }
            Files.setAttribute(path, "dos:hidden", true);
            Files.setAttribute(path, "dos:readonly", true);
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dosFileAttributes.isHidden());
            System.out.println(dosFileAttributes.isReadOnly());

            Files.setAttribute(path, "dos:hidden", false);
            Files.setAttribute(path, "dos:readonly", false);
            dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dosFileAttributes.isHidden());
            System.out.println(dosFileAttributes.isReadOnly());

            DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
            dosFileAttributeView.setHidden(true);
            dosFileAttributeView.setReadOnly(true);

            dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dosFileAttributes.isHidden());
            System.out.println(dosFileAttributes.isReadOnly());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
