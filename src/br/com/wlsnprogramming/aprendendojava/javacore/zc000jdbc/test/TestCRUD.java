package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.test;

import java.util.Scanner;

public class TestCRUD {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = Integer.parseInt(entrada.nextLine());
            if (op == 0) {
                System.out.println("Saindo do sistema!");
                break;
            } else if (op == 1) {
                menuComprador();
                CompradorCRUD.executar(Integer.parseInt(entrada.nextLine()));
            } else if (op == 2) {
                menuCarro();
                CarroCRUD.executar(Integer.parseInt(entrada.nextLine()));
            }
        }
    }

    private static void menu() {
        System.out.println("Digite a opção para começar: ");
        System.out.println("1. Comprador");
        System.out.println("2. Carro");
        System.out.println("0. Sair");
    }

    private static void menuComprador() {
        System.out.println("Digite a opção para começar: ");
        System.out.println("1. Inserir comprador");
        System.out.println("2. Atualizar comprador");
        System.out.println("3. Listar todos os compradores");
        System.out.println("4. Buscar comprador por nome");
        System.out.println("5. Deletar comprador");
        System.out.println("9. Voltar");
    }

    private static void menuCarro() {
        System.out.println("Digite a opção para começar: ");
        System.out.println("1. Inserir carro");
        System.out.println("2. Atualizar carro");
        System.out.println("3. Listar todos os carros");
        System.out.println("4. Buscar carro por modelo");
        System.out.println("5. Deletar carro");
        System.out.println("9. Voltar");
    }
}
