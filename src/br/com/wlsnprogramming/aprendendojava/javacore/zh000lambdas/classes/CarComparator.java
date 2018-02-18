package br.com.wlsnprogramming.aprendendojava.javacore.zh000lambdas.classes;

public class CarComparator {

    public static int compareByColor(Carro carro1, Carro carro2) {
        return carro1.getCor().compareTo(carro2.getCor());
    }

    public int compareByName(Carro carro1, Carro carro2) {
        return  carro1.getNome().compareTo(carro2.getNome());
    }
}
