package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.runtimeexception.tests;

public class RuntimeExceptionTest {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        if(b != 0) {
            int c = a / b;
            System.out.println(c);
        }

        ////////////////////////////////////////////////////

        Object o = null;
        if(o != null)
            System.out.println(o.toString());

        ///////////////////////////////////////////////////

        try {
            int[] array = new int[2];
            System.out.println(array[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(divisao(10, 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int divisao(int numero1, int numero2) {
        if(numero2 == 0)
            throw new IllegalArgumentException("Passe um valor diferente de 0 para numero2");
        return numero1 / numero2;
    }
}
