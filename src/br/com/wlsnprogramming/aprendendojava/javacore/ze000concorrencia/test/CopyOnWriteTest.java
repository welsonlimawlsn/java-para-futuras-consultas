package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTest implements Runnable {
    private List<String> list = new CopyOnWriteArrayList<>();

    public CopyOnWriteTest() {
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 9000; i++) {
            list.add(String.valueOf(" - " + i + " - "));
            System.out.println("Adicionou " + i);
        }
        currentTime = System.currentTimeMillis() - currentTime;
        System.out.println("Demorou " + currentTime + "milisegundos");
    }

    public static void main(String[] args) {
        CopyOnWriteTest copyOnWriteTest = new CopyOnWriteTest();
        Thread thread = new Thread(copyOnWriteTest, "A");
        Thread thread2 = new Thread(copyOnWriteTest, "B");
        Thread removedor = new Thread(new RemoverMembros<>(copyOnWriteTest.getList()), "B");

        thread.start();
        thread2.start();
        removedor.start();
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (iterator.hasNext()) {
            System.out.println(Thread.currentThread().getName() + ": " + iterator.next());
        }
    }

    public List<String> getList() {
        return list;
    }

    private static class RemoverMembros<T> implements Runnable {
        private List<T> list;

        public RemoverMembros(List<T> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(Thread.currentThread().getName() + " removeu " + list.remove(i));
            }
        }
    }
}
