package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador {
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            atomicInteger.getAndIncrement();
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public int getAtomicInteger() {
        return atomicInteger.intValue();
    }
}

class IncrementadorThread extends Thread {
    private Contador contador;

    public IncrementadorThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            contador.increment();
        }
    }
}

public class ConcorrenciaTest {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        IncrementadorThread incrementadorThread = new IncrementadorThread(contador);
        IncrementadorThread incrementadorThread1 = new IncrementadorThread(contador);

        incrementadorThread.start();
        incrementadorThread1.start();

        incrementadorThread.join();
        incrementadorThread1.join();

        System.out.println(contador.getCount());
        System.out.println(contador.getAtomicInteger());
    }
}
