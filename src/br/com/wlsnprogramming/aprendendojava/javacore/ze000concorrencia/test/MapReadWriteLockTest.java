package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {
    private Map<String, String> map = new LinkedHashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public Object[] allKeys() {
        return map.keySet().toArray();
    }
}

public class MapReadWriteLockTest {
    private final static MapReadWrite MAP_READ_WRITE = new MapReadWrite();
    private final static ReentrantReadWriteLock REENTRANT_READ_WRITE_LOCK = new ReentrantReadWriteLock();
    private static Random random = new Random();

    public static void main(String[] args) {

        new Thread(new Write(), "Write").start();
        new Thread(new ReadA(), "ReadA").start();
        new Thread(new ReadB(), "ReadB").start();

    }

    static class Write implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                REENTRANT_READ_WRITE_LOCK.writeLock().lock();
                try {
                    MAP_READ_WRITE.put(String.valueOf(i), String.valueOf(i));
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    REENTRANT_READ_WRITE_LOCK.writeLock().unlock();
                }
            }
        }
    }

    static class ReadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                REENTRANT_READ_WRITE_LOCK.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + Arrays.toString(MAP_READ_WRITE.allKeys()));
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    REENTRANT_READ_WRITE_LOCK.readLock().unlock();
                }
            }
        }
    }

    static class ReadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                REENTRANT_READ_WRITE_LOCK.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + Arrays.toString(MAP_READ_WRITE.allKeys()));
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    REENTRANT_READ_WRITE_LOCK.readLock().unlock();
                }
            }
        }
    }
}
