package br.com.wlsnprogramming.aprendendojava.javacore.zb000classesinternas.test;

class External {
    static class Internal {
        public void print() {
            System.out.println("Olá");
        }
    }
}

public class StaticInternalClassTest {

    public static void main(String[] args) {

        External.Internal test = new External.Internal();
        test.print();

        Internal2 internal2 = new Internal2();
        internal2.print();
    }

    static class Internal2 {
        public void print() {
            System.out.println("Olá, interna 2");
        }
    }
}
