package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {
    public static void main(String[] args) {
        Path directoryZip = Paths.get("pasta");
        Path directoryFiles = Paths.get("pasta/subpasta/subsubpasta");
        Path zipFile = directoryZip.resolve("compressFile.zip");

        try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryFiles)) {
            for(Path path : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                outputStream.putNextEntry(zipEntry);
                FileInputStream fileInputStream = new FileInputStream(path.toFile());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                byte[] buffer = new byte[2048];
                int bytesRead;
                outputStream.write(bufferedInputStream.read());
                while((bytesRead = bufferedInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
                outputStream.closeEntry();
                bufferedInputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
