package br.com.wlsnprogramming.aprendendojava.javacore.w000io.test;

import java.io.*;

public class StreamsTest {
    public static void main(String[] args) {
        gravadorTunado();
        leitorTunado();
    }

    private static void gravador() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (FileOutputStream outputStream = new FileOutputStream("pasta/stream.txt")) {
            outputStream.write(dados);
            outputStream.flush();
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gravadorTunado() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"), 4098)) {
            outputStream.write(dados);
            outputStream.flush();
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitor() {
        try (FileInputStream inputStream = new FileInputStream("pasta/stream.txt")) {
            int leitura;
            while ((leitura = inputStream.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitorTunado() {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("pasta/stream.txt"), 4098)) {
            int leitura;
            while ((leitura = inputStream.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(b + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
