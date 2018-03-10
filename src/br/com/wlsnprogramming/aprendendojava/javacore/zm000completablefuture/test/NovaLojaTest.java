package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes.Desconto;
import br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes.NovaLoja;
import br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes.Orcamento;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NovaLojaTest {
    public static void main(String[] args) {
        List<NovaLoja> lojas = NovaLoja.getNovaLojaList();
        //lojas.forEach(l -> System.out.println(l.getPreco()));
        //acharPrecos(lojas).forEach(System.out::println);
        Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        //acharPrecosAsync(lojas, executor).forEach(System.out::println);
        CompletableFuture[] completableFutures = acharPrecosStream(lojas, executor).map(f -> f.thenAccept(System.out::println)).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
//        CompletableFuture.anyOf(completableFutures).join();
    }

    private static List<String> acharPrecos(List<NovaLoja> lojas) {
        System.out.println("Stream Sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream()
                .map(NovaLoja::getPreco)
                .map(Orcamento::parse)
                .map(Desconto::calcularDesconto)
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start + "ms");
        return collect;
    }

    private static List<String> acharPrecosAsync(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completable Future Async");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> completableFutures = lojas.stream()
                // Pega o preco original de forma async
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                // Transfoma a string em um Orçamento no momento em que ele se torna disponivel
                .map(future -> future.thenApply(Orcamento::parse))
                // Compondo o primeiro future com mais uma chamada async, para pegar os decontos
                // no momento que a primeira requisição async estiver disponivel
                .map(future -> future.thenCompose(orcamento -> CompletableFuture.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)))
                .collect(Collectors.toList());

        // Espera todos os futures no stream finalizarem para terem seu resultados extraidos
        List<String> collect1 = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start + "ms");
        return collect1;
    }

    private static Stream<CompletableFuture<String>> acharPrecosStream(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completable Future Async");
        long start = System.currentTimeMillis();
        Stream<CompletableFuture<String>> completableFutureStream = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                .map(future -> future.thenApply(Orcamento::parse))
                .map(future -> future.thenCompose(
                        orcamento -> CompletableFuture.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)));

        System.out.println(System.currentTimeMillis() - start + "ms");
        return completableFutureStream;
    }
}
