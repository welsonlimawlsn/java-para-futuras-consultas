package br.com.wlsnprogramming.aprendendojava.javacore.s000strings.test;

public class StringPerformanceTest {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatStringBuider(100000);
        long fim = System.currentTimeMillis();

        System.out.println("Tempo gasto: " + (fim - inicio) + "ms");
        //4270ms
        System.out.println(concatStringRec(10, ""));
    }

    private static String concatString(int tam, String string) {
        for(int i = 0; i < tam; i++){
            string += 1;
        }
        return string;
    }

    public static void concatString(int tam){
        String string = "";
        for(int i = 0; i < tam; i++){
            string += i;
        }
    }

    public static void concatStringBuider(int tam) {
        StringBuilder stringBuilder = new StringBuilder(tam);
        for(int i = 0; i < tam; i++) {
            stringBuilder.append(i);
        }
    }
    public static void concatStringBuffer(int tam) {
        StringBuffer stringBuffer = new StringBuffer(tam);
        for(int i = 0; i < tam; i++) {
            stringBuffer.append(i);
        }
    }

    private static String concatStringRec(int tam, String str) {
        if(tam == 0)
            return str;
        else
            return concatStringRec(tam-1, str + 1);
    }
}
