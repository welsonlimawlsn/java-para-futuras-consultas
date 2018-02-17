package br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.test;

public class DeadLockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new ThreadExemplo1().start();
        new ThreadExemplo2().start();
    }

    private static class ThreadExemplo1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Segurando lock 1");
                System.out.println("Thread 1: Experando pelo lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Segurando lock 1 e 2");
                }
            }
        }
    }

    private static class ThreadExemplo2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Experando pelo lock 1");
                synchronized (lock2) {
                    System.out.println("Thread 2: Segurando lock 2 e 1");
                }
            }
        }
    }
}
