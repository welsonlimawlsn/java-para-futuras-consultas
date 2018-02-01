package br.com.wlsnprogramming.aprendendojava.javacore.r000wrappers.test;

public class WrappersTest {
    public static void main(String[] args) {
        byte bytePrimitivo = 1;
        short shortPrimitivo = 2;
        int intPrimitivo = 3;
        long longPrimitivo = 4;
        float floatPrimitico = 5;
        double doublePrimitivo = 6;
        char charPrimitivo = '7';
        boolean booleanPrimitivo = true;

        Byte byteWrapper = 1;
        Short shortWraper = 2;
        Integer integerWrapper = 3;
        Integer integerWrapper2 = new Integer("10");
        Long longWrapper = 4L;
        Long longWrapperWrapper = Long.valueOf("10");
        Float floatWrapper = 5f;
        Double doubleWrapper = 6d;
        Character characterWrapper = '7';
        Boolean booleanWrapper = true;


        String valor = "10";
        Float f = Float.parseFloat(valor);

        System.out.println(Character.isDigit('8'));
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isLetterOrDigit('8'));
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
    }
}
