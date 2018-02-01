package br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes;

public class Client {

    private static int[] parcels;

    static {
        System.out.println("Bloco de inicialização");
        parcels = new int[100];
        for (int i = 0; i < parcels.length; i++) {
            parcels[i] = i + 1;
        }
    }

    public Client() {

    }

    public static int[] getParcels() {

        return parcels;
    }

}
