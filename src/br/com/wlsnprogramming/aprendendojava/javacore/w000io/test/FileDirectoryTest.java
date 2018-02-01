package br.com.wlsnprogramming.aprendendojava.javacore.w000io.test;

import java.io.File;
import java.io.IOException;

public class FileDirectoryTest {

    public static void main(String[] args) throws IOException {

        File directory = new File("folder");
        boolean mkdir = directory.mkdir();

        System.out.println("Create directory: " + mkdir);

        File file = new File(directory, "file.txt");
        boolean newFile = file.createNewFile();
        System.out.println("Create a new file: " + newFile);

        File nameNewFile = new File(directory,"renamedFile.txt");
        boolean renameTo = file.renameTo(nameNewFile);
        System.out.println(file.getName() + " renamed to " + nameNewFile.getName());

        File renamedDirectory = new File("folder2");
        boolean rename = directory.renameTo(renamedDirectory);

        System.out.println("Directory " + directory.getName() + " renamed to " + renamedDirectory.getName());

        System.out.println("---------------------------------------------------------");
        getFiles(new File("C:\\Users\\welso\\IdeaProjects\\JavaOnline"), "-");

    }

    public static void getFiles(){
        File file = new File("C:\\Users\\welso\\IdeaProjects\\JavaOnline");
        String[] listFiles = file.list();
        for(String fileName : listFiles) {
            System.out.println(fileName);
        }
    }

    public static void getFiles(File directory, String tab) {
        if(directory.isDirectory()) {
            String[] listFiles = directory.list();
            for(String file : listFiles) {
                File file1 = new File(directory.getAbsolutePath() + "\\" + file);
                System.out.println(tab + file1.getName());
                if(file1.isDirectory()) {
                    getFiles(file1, tab + ">");
                }
            }
        }
    }
}
