package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {

    private String nome;

    public Loja() {

    }

    public Loja(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        //Vai pegar o preco aonde judas perdeu as botas
        return calcularPreco();
    }

    public Future<Double> getPrecoAsync() {
        CompletableFuture<Double> precoFutudo = new CompletableFuture<>();
        new Thread(() -> {
            try {
                precoFutudo.complete(calcularPreco());
            } catch (Exception e) {
                precoFutudo.completeExceptionally(e);
            }
        }).start();
        return precoFutudo;
    }

    public Future<Double> getPrecoAsyncTunado() {
        return CompletableFuture.supplyAsync(this::calcularPreco);
    }

    private double calcularPreco() {
        delay();
        //System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
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
