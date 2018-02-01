package br.com.wlsnprogramming.aprendendojava.javacore.zb000classesinternas.test;

public class ClassesInternasTest {

    private String nome = "Welson";

    public static void main(String[] args) {
        ClassesInternasTest externa = new ClassesInternasTest();
        ClassesInternasTest.Interna interna = externa.new Interna();
        ClassesInternasTest.Interna interna1 = new ClassesInternasTest().new Interna();
        interna.verClasseExterna();
        interna1.verClasseExterna();
    }

    class Interna {
        public void verClasseExterna(){
            System.out.println(nome);
            System.out.println(this);
            System.out.println(ClassesInternasTest.this);
        }
    }
}

//class Externa {
//    private String nome = "Welson";
//
//    class Interna {
//        public void verClasseExterna(){
//            System.out.println(nome);
//        }
//    }
//}
