package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.concurrent.*;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() + " executando...");
        }
        return "Trabalho finalizado, o número aleatório é " + count;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> resultFuture = executorService.submit(callableTest);
        System.out.println(resultFuture.get());
        executorService.shutdown();
    }
}
