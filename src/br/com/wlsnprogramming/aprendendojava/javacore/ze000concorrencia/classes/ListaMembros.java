package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {

    private final Queue<String> emails = new LinkedList<>();
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition conditionLock = reentrantLock.newCondition();
    private boolean aberta = true;

    public int getEmailsPendentes() {
        reentrantLock.lock();
        try {
            return emails.size();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean isAberta() {
        return aberta;
    }

    public String obterEmailMembro() {
        String email = null;
        try {
            reentrantLock.lock();
            while (emails.size() == 0) {
                if (!aberta) return null;
                System.out.println("Lista vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo wait.");
                conditionLock.await();
            }
            email = this.emails.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return email;
    }

    public void addEmailMembro(String email) {
        reentrantLock.lock();
        try{
            emails.add(email);
            System.out.println("Email adicionado a lista.");
            System.out.println("Notificando as Threads que estão em espera.");
            conditionLock.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void fecharLista() {
        System.out.println("Notificando todas as threads e fechando a lista");
        aberta = false;

        reentrantLock.lock();
        try {
            conditionLock.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }
}
