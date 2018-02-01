package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AtributosBasicosTest {
    public static void main(String[] args) throws IOException {
        Date primeiroJaneiro = new GregorianCalendar(2018, Calendar.JANUARY, 2018).getTime();
        File file = new File("folder2\\arquivo.txt");
        file.createNewFile();
        System.out.println(file.lastModified());
        file.setLastModified(primeiroJaneiro.getTime());
        System.out.println(file.lastModified());
        file.delete();

        Path path = Paths.get("folder2\\arquivo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.fromMillis(primeiroJaneiro.getTime());
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.getLastModifiedTime(path));
        Files.deleteIfExists(path);

        path = Paths.get("src\\br\\com\\wlsnprogramming\\aprendendojava\\javacore\\a000ntroducaoclasses\\classes\\Carro.java");

        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));

        //BasicFileAttributes, PosixFileAttributes, DosFileAttributes
        System.out.println("================================================");

        BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(fileAttributes.creationTime());
        System.out.println(fileAttributes.lastAccessTime());
        System.out.println(fileAttributes.lastModifiedTime());
        System.out.println(fileAttributes.isDirectory());
        System.out.println(fileAttributes.isSymbolicLink());
        System.out.println(fileAttributes.isRegularFile());

        //BasicFileAttributeView, PosixFileAttributeView, DosFileAttributeView, FileOwnerAttributeView, AclFileAttributeView

        FileTime lastModified = fileAttributes.lastModifiedTime();
        FileTime created = fileAttributes.creationTime();
        FileTime lastAcess = FileTime.fromMillis(System.currentTimeMillis());

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        fileAttributeView.setTimes(lastModified,lastAcess, created);

        System.out.println("===============================================");
        fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println(fileAttributes.creationTime());
        System.out.println(fileAttributes.lastAccessTime());
        System.out.println(fileAttributes.lastModifiedTime());


    }
}
