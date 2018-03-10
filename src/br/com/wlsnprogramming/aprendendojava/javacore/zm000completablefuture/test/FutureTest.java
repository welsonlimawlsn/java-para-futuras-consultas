package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.test;

import java.util.concurrent.*;

public class FutureTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Future<Double> doubleFuture = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 2000D;
        });
        enrolando();

        try {
            Double resultado = doubleFuture.get(3, TimeUnit.SECONDS);
            System.out.println(resultado);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        System.out.println(soma);
    }
}
