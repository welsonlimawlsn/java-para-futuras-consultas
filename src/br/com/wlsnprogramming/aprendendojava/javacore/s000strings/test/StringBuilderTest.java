package br.com.wlsnprogramming.aprendendojava.javacore.s000strings.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "Uma frase comum";
        StringBuilder sb = new StringBuilder(10);
        sb.append("Uma frase comum");
        sb.reverse();
        sb.delete(0, 3);
        sb.reverse();
        sb.insert(0, "welso");
        System.out.println(sb);
    }
}
