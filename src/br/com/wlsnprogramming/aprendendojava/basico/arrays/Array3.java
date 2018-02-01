package br.com.wlsnprogramming.aprendendojava.basico.arrays;

public class Array3 {
    public static void main(String[] args) {
        int[][] dias = new int[2][2];

        dias[0][0] = 30;
        dias[0][1] = 31;
        dias[1][0] = 29;
        dias[1][1] = 28;

        for(int i = 0; i < dias.length; i++){
            for(int ii = 0; ii < dias[i].length; ii++){
                System.out.println(dias[i][ii]);
            }
        }

        for (int[] ref : dias){
            for(int dia : ref){
                System.out.println(dia);
            }
        }
    }
}
