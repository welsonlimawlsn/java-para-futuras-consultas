package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadWorkerExecuter implements Runnable {

    private String run;
    private static Random random = new Random();

    public ThreadWorkerExecuter(String run) {
        this.run = run;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " iniciou " + run);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadName + " finalizou");
    }
}

public class ExecutorTest {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        //ExecutorService executorService = Executors.newFixedThreadPool(4);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

       // ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        //threadPoolExecutor.setCorePoolSize(6);

        executorService.execute(new ThreadWorkerExecuter("1"));
        executorService.execute(new ThreadWorkerExecuter("2"));
        executorService.execute(new ThreadWorkerExecuter("3"));
        executorService.execute(new ThreadWorkerExecuter("4"));
        executorService.execute(new ThreadWorkerExecuter("5"));
        executorService.execute(new ThreadWorkerExecuter("6"));
        executorService.execute(new ThreadWorkerExecuter("7"));
        executorService.execute(new ThreadWorkerExecuter("8"));
        executorService.shutdown();
        System.out.println(executorService.isTerminated());

        System.out.println("Finalizado");

    }
}
