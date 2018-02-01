package br.com.wlsnprogramming.aprendendojava.javacore.e000blocodeinicializacao.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.e000blocodeinicializacao.classes.Client;

public class ClientTest {

    public static void main(String[] args){

        Client client = new Client();

        System.out.println("\nExibindo quantidade de parcelas (Test): ");

        for(int parcel : client.getParcels()) {
            System.out.print(parcel + " ");
        }

    }

}
