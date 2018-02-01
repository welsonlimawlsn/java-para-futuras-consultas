package br.com.wlsnprogramming.aprendendojava.javacore.e000blocodeinicializacao.classes;

public class Client {

    private int[] parcels;

    {
        parcels = new int[100];
        for (int i = 0; i < parcels.length; i++) {
            parcels[i] = i + 1;
        }
    }

    public Client() {

    }

    public int[] getParcels() {

        return parcels;
    }

    public void setParcels(int[] parcels) {

        this.parcels = parcels;
    }

}
