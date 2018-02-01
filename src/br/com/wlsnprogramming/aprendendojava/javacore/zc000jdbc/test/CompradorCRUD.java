package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Comprador;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.db.CompradorDAO;

import java.util.List;
import java.util.Scanner;

class CompradorCRUD {

    private static Scanner entrada = new Scanner(System.in);

    static void executar(int op) {
        switch (op) {
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listarTodos();
                break;
            case 4:
                System.out.println("Digite um nome");
                buscar(entrada.nextLine());
                break;
            case 5:
                excluir();
                break;
        }
    }

    private static void inserir() {
        Comprador comprador = new Comprador();

        System.out.print("Nome: ");
        comprador.setNome(entrada.nextLine());

        System.out.print("CPF: ");
        comprador.setCpf(entrada.nextLine());

        CompradorDAO.save(comprador);

        System.out.println("============================");
        System.out.println("Comprador salvo com sucesso!");
        System.out.println("============================");
    }

    private static List<Comprador> listar(List<Comprador> compradores) {
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < compradores.size(); i++) {
            System.out.println("ID: " + i + " - NOME: " + compradores.get(i).getNome() + " - CPF: " + compradores.get(i).getCpf());
            System.out.println("----------------------------------------------------------");
        }
        return compradores;
    }

    public static List<Comprador> listarTodos() {
        return listar(CompradorDAO.listAll());
    }

    private static void buscar(String nome) {
        listar(CompradorDAO.searchByName(nome));
    }

    private static void atualizar() {
        System.out.println("Selecione um dos compradores abaixo digitando o ID:");

        List<Comprador> compradorList = listarTodos();
        System.out.print("ID: ");
        Comprador comprador = compradorList.get(Integer.parseInt(entrada.nextLine()));

        System.out.println("Comprador selecionado: ");
        System.out.println("ID: " + comprador.getId() + " - NOME: " + comprador.getNome() + " - CPF: " + comprador.getCpf());

        System.out.print("Digite um novo nome ou ENTER para manter: ");
        String nome = entrada.nextLine();

        System.out.print("Digite um novo CPF ou ENTER para manter: ");
        String cpf = entrada.nextLine();

        if (!nome.isEmpty()) {
            comprador.setNome(nome);
        }

        if (!cpf.isEmpty()) {
            comprador.setCpf(cpf);
        }

        CompradorDAO.update(comprador);

        System.out.println("=================================");
        System.out.println("Comprador atualizado com sucesso!");
        System.out.println("=================================");
    }

    private static void excluir() {

        System.out.println("Selecione um dos compradores abaixo digitando o ID:");
        List<Comprador> compradorList = listarTodos();
        System.out.print("ID: ");
        Comprador comprador = compradorList.get(Integer.parseInt(entrada.nextLine()));
        System.out.println("ID: " + comprador.getId() + " - NOME: " + comprador.getNome() + " - CPF: " + comprador.getCpf());
        System.out.print("Tem certeza? S/N");
        if (entrada.nextLine().equalsIgnoreCase("S")) {
            CompradorDAO.delete(comprador);
        }

        System.out.println("===============================");
        System.out.println("Comprador excluido com sucesso!");
        System.out.println("===============================");
    }

}
