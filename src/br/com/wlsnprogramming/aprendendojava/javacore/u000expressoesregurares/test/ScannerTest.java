package br.com.wlsnprogramming.aprendendojava.javacore.u000expressoesregurares.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner("1 true 100 oi");

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        System.out.println("#############################");
        Scanner scanner1 = new Scanner("1 true 100 oi");

        while (scanner1.hasNext()) {
            if (scanner1.hasNextInt()) {
                int i = scanner1.nextInt();
                System.out.println(i);
            } else if (scanner1.hasNextBoolean()) {
                boolean i = scanner1.nextBoolean();
                System.out.println(i);
            } else {
                System.out.println(scanner1.next());
            }
        }
    }
}
