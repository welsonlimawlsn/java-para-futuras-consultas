package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes.Loja;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class LojaTest2 {

    private static long start;

    public static void main(String[] args) {
        List<Loja> lojaList = asList(
                new Loja("Americanas"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon"),
                new Loja("Casas Bahia"),
                new Loja("BestBuy"),
                new Loja("Amazon")
        );
        comecarContar();
        System.out.println(acharPrecos(lojaList));
        totalTempo();
        System.out.println("===========================");
        comecarContar();
        System.out.println(acharPrecos2(lojaList));
        totalTempo();
        System.out.println("===========================");
        comecarContar();
        System.out.println(acharPrecos3(lojaList));
        totalTempo();
        System.out.println("===========================");
        comecarContar();
        System.out.println(acharPrecos4(lojaList));
        totalTempo();

        // numeroDeThreads = Ncpu * Ucpu * (1 + W/C)
        // Ncpu = numero de cores disponiveis
        System.out.println(Runtime.getRuntime().availableProcessors());

        //Ucpu = a utilização da CPU (0-1)

        // W/C wait time and compute time

        final Executor executor = Executors.newFixedThreadPool(Math.min(lojaList.size(), 100), r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        comecarContar();
        System.out.println(acharPrecos5(lojaList, executor));
        totalTempo();
    }

    private static List<String> acharPrecos(List<Loja> lojaList) {
        return lojaList.stream()
                .map(loja -> String.format("O preço na loja %s é de R$ %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
    }

    private static List<String> acharPrecos2(List<Loja> lojaList) {
        return lojaList.parallelStream()
                .map(loja -> String.format("O preço na loja %s é de R$ %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
    }

    private static List<String> acharPrecos3(List<Loja> lojaList) {
        return lojaList.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("O preço na loja %s é de R$ %.2f", loja.getNome(), loja.getPreco())))
                .map(CompletableFuture::join).collect(Collectors.toList());
    }

    private static List<String> acharPrecos4(List<Loja> lojaList) {
        List<CompletableFuture<String>> collect = lojaList.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("O preço na loja %s é de R$ %.2f", loja.getNome(), loja.getPreco())))
                .collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private static List<String> acharPrecos5(List<Loja> lojaList, Executor executor) {
        List<CompletableFuture<String>> collect = lojaList.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("O preço na loja %s é de R$ %.2f", loja.getNome(), loja.getPreco()), executor))
                .collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private static void comecarContar() {
        start = System.currentTimeMillis();
    }
    private static void totalTempo() {
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
