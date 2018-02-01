package br.com.wlsnprogramming.aprendendojava.javacore.zb000classesinternas.test;

public class LocaleClassesTest {
    private String firstName = "Welson";

    private void run(){
        class Interna {
            public void printExternalName(){
                System.out.println(firstName);
            }
        }
        new Interna().printExternalName();
    }

    public static void main(String[] args) {
        LocaleClassesTest localeClassesTest = new LocaleClassesTest();
        localeClassesTest.run();
    }
}
