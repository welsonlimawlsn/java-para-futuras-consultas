package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.test;

import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Consumidor;
import br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapTest {
    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor("Welson", "123.456.789-12");

        Consumidor consumidor1 = new Consumidor("Wilson", "987.654.321-98");


        Produto nootbookLenovo = new Produto("123", "Nootbook Lenovo", 2000, 1);
        Produto picanha = new Produto("854", "Picanha", 26.4, 0);
        Produto tecladoRazer = new Produto("147", "Teclado Razer", 500, 10);
        Produto samsungGalaxyS8 = new Produto("457", "Samsung Galaxy S8", 3509.89, 0);
        Produto samsungGalaxyS9 = new Produto("457", "Samsung Galaxy S9", 3509.89, 0);

        List<Produto> produtosConsumidor1 = new ArrayList<>();
        produtosConsumidor1.add(samsungGalaxyS9);
        produtosConsumidor1.add(nootbookLenovo);

        List<Produto> produtosConsumidor2 = new ArrayList<>();
        produtosConsumidor2.add(nootbookLenovo);
        produtosConsumidor2.add(samsungGalaxyS8);
        produtosConsumidor2.add(tecladoRazer);


        Map<Consumidor, List<Produto>> map = new HashMap<>();

        map.put(consumidor, produtosConsumidor1);
        map.put(consumidor1, produtosConsumidor2);

        for(Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
            System.out.println("O consumidor " + entry.getKey().getNome() + " comprou: ");
            for(Produto produto : entry.getValue()) {
                System.out.println(" - " + produto.getNome());
            }
        }
    }
}
