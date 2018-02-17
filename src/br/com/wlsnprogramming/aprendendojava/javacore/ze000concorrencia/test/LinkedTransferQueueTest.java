package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        System.out.println(transferQueue.add("Welson"));
        transferQueue.put("Maria");
        System.out.println(transferQueue.offer("Iraldo"));
        transferQueue.offer("Iraldo", 5, TimeUnit.SECONDS);
        //transferQueue.transfer("Wilson");
        System.out.println(transferQueue.tryTransfer("Welson"));
        System.out.println(transferQueue.remainingCapacity());

        System.out.println(transferQueue.element());
        System.out.println(transferQueue.peek());
        System.out.println(transferQueue.poll());
        System.out.println(transferQueue.remove());
        System.out.println(transferQueue.take());
    }
}
