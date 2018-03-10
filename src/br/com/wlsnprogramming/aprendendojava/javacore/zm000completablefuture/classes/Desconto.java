package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Desconto {

    public enum Codigo {
        NENHUM(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);

        private final int PORCENTAGEM;

        Codigo(int porcentagem) {
            this.PORCENTAGEM = porcentagem;
        }

        public int getPorcentagem() {
            return PORCENTAGEM;
        }
    }

    public static String calcularDesconto(Orcamento orcamento) {
        return String.format("No(a) %s o preço original é R$ %.2f, com desconto de %d fica com preco final de R$ %.2f",
                orcamento.getNomeLoja(),
                orcamento.getPreco(),
                orcamento.getCodigoDesconto().getPorcentagem(),
                calculo(orcamento.getPreco(), orcamento.getCodigoDesconto()));
    }

    private static double calculo(double preco, Codigo codigo) {
        delay();
        return preco - (preco / 100 * codigo.getPorcentagem());
    }

    private static void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
