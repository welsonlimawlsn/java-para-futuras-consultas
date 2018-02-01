package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvercaoListArrayTest {

    public static void main(String[] args) {

        List<String> nomeList = new ArrayList<>();
        nomeList.add("Welson de Lima Teles");
        nomeList.add("Maria Jesus de Lima Menezes");
        nomeList.add("Iraldo Teles de Menezes");

        String[] nomeArray = new String[nomeList.size()];
        nomeList.toArray(nomeArray);

        System.out.println(Arrays.toString(nomeArray));

        String[] cidadeArray = new String[]{
                "Ceilâdia",
                "Brasília",
                "Taguatinga",
                "Águas Claras"
        };

        List<String> cidadeList = Arrays.asList(cidadeArray);//Todas as alterações realizadas aqui, tambem fara a alteração no array, logo não é possivel adicionar novos objetos aqui.

        System.out.println(Arrays.toString(cidadeArray));
        System.out.println(cidadeList);

        System.out.println("================================================");

        cidadeList.set(3, "Paranoá");

        System.out.println(Arrays.toString(cidadeArray));
        System.out.println(cidadeList);

        List<String> cidadeList2 = new ArrayList<>(Arrays.asList(cidadeArray));
        cidadeList2.add("Park Way");
        cidadeList2.set(3, "Guará");
        System.out.println(cidadeList2);
    }
}
