package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        blockingQueue.put("Welson");
        System.out.println(blockingQueue.peek());
        System.out.println("Tentando colocar outro valor");

        Thread thread = new Thread(new RemoveFromQueue(blockingQueue), "BlockingQueue");
        thread.start();

        blockingQueue.put("Maria");
        System.out.println("Inserido o último valor");
    }
    static class RemoveFromQueue implements Runnable {

        private BlockingQueue blockingQueue;

        public RemoveFromQueue(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " entrando em espera por 2 segundos.");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Removendo o valor: " + blockingQueue.take().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
