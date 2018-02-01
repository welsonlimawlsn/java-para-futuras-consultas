package br.com.wlsnprogramming.aprendendojava.javacore.w000io.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\aequivos_criados_com_java\\arquivo.txt");
        try {
            boolean createFile = file.createNewFile();
            System.out.println("Create file: " + createFile);
            System.out.println(file.exists());
            System.out.println("Permissão para leitura? " + file.canRead());
            System.out.println("Permissão para escrita? " + file.canWrite());
            System.out.println("Caminho: " + file.getPath());
            System.out.println("Caminho completo: " + file.getAbsolutePath());
            System.out.println("É um diretório: " + file.isDirectory());
            System.out.println("É um arquivo oculto? " + file.isHidden());
            System.out.println("Última atualização: " + DateFormat.getInstance().format(new Date(file.lastModified())));

            if(file.exists()) {
                System.out.println("Deletado? " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
