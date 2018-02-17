package br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.classes.Conta;

public class ContaTest implements Runnable {

    private Conta conta = new Conta();
    private int valor;

    public ContaTest(int valor) {
        this.valor = valor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(conta.saque(valor, Thread.currentThread().getName())) {
                System.out.println("----------------------------------------------------------");
                System.out.println(Thread.currentThread().getName() + " sacou R$" + valor);
                System.out.println("----------------------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        ContaTest contaTest = new ContaTest(10);
        Thread welson = new Thread(contaTest, "Welson");
        Thread wilson = new Thread(contaTest, "Wilson");
        Thread maria = new Thread(contaTest, "Maria");
        Thread iraldo = new Thread(contaTest, "iraldo");
        Thread miguel = new Thread(contaTest, "miguel");

        welson.start();
        wilson.start();
        maria.start();
        iraldo.start();
        miguel.start();
    }
}
