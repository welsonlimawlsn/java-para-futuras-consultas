package br.com.wlsnprogramming.aprendendojava.javacore.w000io.test;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        char[] password = c.readPassword("%s", "pw: ");
        for (char pass : password) {
            c.format("%c ", pass);
        }
        c.format("\n");
        String texto;
        while (true) {
            texto = c.readLine("%s", "Digite: ");
            c.format("%s", retorno(texto));
        }
    }

    public static String retorno(String arg) {
        return "Entrada de dados: " + arg;
    }
}
