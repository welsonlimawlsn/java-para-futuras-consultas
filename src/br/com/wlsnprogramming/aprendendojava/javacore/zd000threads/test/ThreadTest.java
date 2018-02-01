package br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.test;


//Deamon x User

class ThreadExemplo extends Thread {
    private char c;

    public ThreadExemplo(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("\n=================" + Thread.currentThread().getName() + "=================");
        for(int i = 0; i < 1000; i++) {
            System.out.print(c);
            if(i % 100 == 0) {
                System.out.println();
            }
        }
    }
}

class ThreadExemploRunnable implements Runnable {

    private char c;

    public ThreadExemploRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("\n=================" + Thread.currentThread().getName() + "=================");
        for(int i = 0; i < 1000; i++) {
            System.out.print(c);
            if(i % 100 == 0) {
                System.out.println();
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
//        ThreadExemplo threadExemplo = new ThreadExemplo('a');
//        ThreadExemplo threadExemplo1 = new ThreadExemplo('b');
//        ThreadExemplo threadExemplo2 = new ThreadExemplo('c');
//        ThreadExemplo threadExemplo3 = new ThreadExemplo('d');
//        ThreadExemplo threadExemplo4 = new ThreadExemplo('f');

//        threadExemplo.start();
//        threadExemplo1.start();
//        threadExemplo2.start();
//        threadExemplo3.start();
//        threadExemplo4.start();

        Thread thread = new Thread(new ThreadExemploRunnable('a'));
        Thread thread1 = new Thread(new ThreadExemploRunnable('b'));
        Thread thread2 = new Thread(new ThreadExemploRunnable('c'));
        Thread thread3 = new Thread(new ThreadExemploRunnable('d'));
        Thread thread4 = new Thread(new ThreadExemploRunnable('f'));

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
