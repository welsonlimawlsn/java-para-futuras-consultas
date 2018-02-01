package br.com.wlsnprogramming.aprendendojava.basico.arrays;

public class Array1 {
    public static void main(String[] args) {
        int[] idades = new int[3];
        idades[0] = 19;
        idades[1] = 56;
        idades[2] = 53;

        for(int idade : idades){
            System.out.println(idade);
        }

        String[] nomes = new String[3];
        nomes[0] = "Welson";
        nomes[1] = "Maria";
        nomes[2] = "Iraldo";

        for(int i = 0; i < nomes.length; i++){
            System.out.println(nomes[i]);
        }
    }
}
