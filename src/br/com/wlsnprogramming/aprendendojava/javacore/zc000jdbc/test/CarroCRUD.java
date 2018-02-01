package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Comprador;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.db.CarroDAO;

import java.util.List;
import java.util.Scanner;

public class CarroCRUD {

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
        Carro carro = new Carro();

        System.out.print("Modelo: ");
        carro.setNome(entrada.nextLine());

        System.out.print("Placa: ");
        carro.setPlaca(entrada.nextLine());

        System.out.println("Selecione um dos compradores abaixo digitando o ID:");
        List<Comprador> compradorList = CompradorCRUD.listarTodos();

        carro.setComprador(compradorList.get(Integer.parseInt(entrada.nextLine())));

        CarroDAO.save(carro);

        System.out.println("============================");
        System.out.println("Carro salvo com sucesso!");
        System.out.println("============================");
    }

    private static List<Carro> listar(List<Carro> carros) {
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println("ID: " + i + " - NOME: " + carros.get(i).getNome() + " - PLACA: " + carros.get(i).getPlaca() + " - COMPRADOR: " + carros.get(i).getComprador().getNome());
            System.out.println("----------------------------------------------------------");
        }
        return carros;
    }

    private static List<Carro> listarTodos() {
        return listar(CarroDAO.listAll());
    }

    private static void buscar(String nome) {
        listar(CarroDAO.searchByName(nome));
    }

    private static void atualizar() {
        System.out.println("Selecione um dos carros abaixo digitando o ID:");

        List<Carro> carroList = listarTodos();
        System.out.print("ID: ");
        Carro carro = carroList.get(Integer.parseInt(entrada.nextLine()));

        System.out.println("Carro selecionado: ");
        System.out.println("ID: " + carro.getId() + " - NOME: " + carro.getNome() + " - PLACA: " + carro.getPlaca() + " - COMPRADOR: " + carro.getComprador().getNome());

        System.out.print("Digite um novo nome ou ENTER para manter: ");
        String modelo = entrada.nextLine();

        System.out.print("Digite uma nova placa ou ENTER para manter: ");
        String placa = entrada.nextLine();

        if (!modelo.isEmpty()) {
            carro.setNome(modelo);
        }

        if (!placa.isEmpty()) {
            carro.setPlaca(placa);
        }

        CarroDAO.update(carro);

        System.out.println("=================================");
        System.out.println("Carro atualizado com sucesso!");
        System.out.println("=================================");
    }

    private static void excluir() {

        System.out.println("Selecione um dos carros abaixo digitando o ID:");
        List<Carro> carroList = listarTodos();
        System.out.print("ID: ");
        Carro carro = carroList.get(Integer.parseInt(entrada.nextLine()));
        System.out.println("ID: " + carro.getId() + " - NOME: " + carro.getNome() + " - PLACA: " + carro.getPlaca() + " - COMPRADOR: " + carro.getComprador().getNome());
        System.out.print("Tem certeza? S/N");
        if (entrada.nextLine().equalsIgnoreCase("S")) {
            CarroDAO.delete(carro);
        }

        System.out.println("===============================");
        System.out.println("Carro excluido com sucesso!");
        System.out.println("===============================");
    }
}
