package br.com.wlsnprogramming.aprendendojava.javacore.ze000concorrencia.classes;

import java.util.Random;

public class Conta {
    private int saldo = 50;

    public int getSaldo() {
        return saldo;
    }

    public synchronized boolean saque(int valor, String nome) {
        if(saldo >= valor) {
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saldo -= valor;
            System.out.println("R$ " + valor + " sacado com sucesso por " + nome.trim() + "!");
            System.out.println("Extrato: R$ " + saldo);
            return true;
        } else {
            System.out.println("Saldo insufuciente!");
            System.out.println("Extrato: R$ " + saldo);
            return false;
        }
    }
}
