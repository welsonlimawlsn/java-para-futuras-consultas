package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.error.tests;

public class ErrorTest {
    public static void main(String[] args) {
        stackOverflowError();
    }

    public static void stackOverflowError() {
        stackOverflowError();
    }
}
