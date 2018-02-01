package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.runtimeexception.tests;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class MultiplasRuntimeExceptionTest {

    public static void main(String[] args) {

        try {
            throw new IllegalArgumentException();
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println("Dentro do RuntimeException");
        }

        try {
            talvezLanceException();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
