package br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.classes;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {

    private final Queue<String> emails = new LinkedList<>();

    private boolean aberta = true;

    public int getEmailsPendentes(){
        synchronized (emails) {
            return emails.size();
        }
    }

    public boolean isAberta() {
        return aberta;
    }

    public String obterEmailMembro () {
        String email = null;
        try {
            synchronized (emails) {
                while (emails.size() == 0) {
                    if(!aberta) return null;
                    System.out.println("Lista vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo wait.");
                    this.emails.wait();
                }
                email = this.emails.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email;
    }

    public void addEmailMembro(String email){
        synchronized (emails) {
            emails.add(email);
            System.out.println("Email adicionado a lista.");
            System.out.println("Notificando as Threads que estão em espera.");
            emails.notifyAll();
        }
    }

    public void fecharLista(){
        System.out.println("Notificando todas as threads e fechando a lista");
        aberta = false;
        synchronized (emails) {
            emails.notifyAll();
        }
    }
}
