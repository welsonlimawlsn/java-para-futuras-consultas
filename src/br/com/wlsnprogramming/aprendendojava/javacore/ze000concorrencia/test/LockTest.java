package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Worker("A", reentrantLock)).start();
        new Thread(new Worker("B", reentrantLock)).start();
        new Thread(new Worker("C", reentrantLock)).start();
        new Thread(new Worker("D", reentrantLock)).start();
        new Thread(new Worker("F", reentrantLock)).start();
        new Thread(new Worker("G", reentrantLock)).start();
    }

    static class Worker implements Runnable {

        private String nome;
        private ReentrantLock reentrantLock;

        public Worker(String nome, ReentrantLock reentrantLock) {
            this.nome = nome;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                System.out.println("----------------------------------------------------------------------------");
                if(reentrantLock.isHeldByCurrentThread()) {
                    System.out.printf("Thread %s entrou em uma sessão critica.%n", nome);
                }
                System.out.printf("%d Threads experando na fila.%n", reentrantLock.getQueueLength());
                System.out.printf("Thread %s vai trabalhar por 2 segundos.%n", nome);
                Thread.sleep(2000);
                System.out.printf("Thread %s finalizou trabalho.%n", nome);
                System.out.println("----------------------------------------------------------------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
