package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public class NovaLoja {

    private String nome;

    public NovaLoja() {

    }

    public NovaLoja(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        double preco = calcularPreco();
        Desconto.Codigo codigo = Desconto.Codigo.values()[ThreadLocalRandom.current().nextInt(Desconto.Codigo.values().length)];
        return String.format("%s:" + preco + ":%s", nome, codigo);
    }

    public static List<NovaLoja> getNovaLojaList() {
        return new ArrayList<>(asList(
                new NovaLoja("Casas Bahia"),
                new NovaLoja("Ponto Frio"),
                new NovaLoja("Ricardo Eletro"),
                new NovaLoja("Americanas"),
                new NovaLoja("Fujioka"),
                new NovaLoja("Wallmart"),
                new NovaLoja("Extra")
        ));
    }

    private double calcularPreco() {
        delay();
        //System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
