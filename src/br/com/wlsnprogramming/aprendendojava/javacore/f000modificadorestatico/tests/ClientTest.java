package br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.tests;


import br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes.Client;

public class ClientTest {

    public static void main(String[] args){

        Client client = new Client();
        Client client1 = new Client();

        System.out.println("\nExibindo quantidade de parcelas (Test): ");

        for(int parcel : client.getParcels()) {
            System.out.print(parcel + " ");
        }

    }

}
