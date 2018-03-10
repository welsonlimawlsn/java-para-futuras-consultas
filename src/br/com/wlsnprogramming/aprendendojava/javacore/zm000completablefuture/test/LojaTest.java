package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes.Loja;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LojaTest {
    public static void main(String[] args) {
        Loja americanas = new Loja();
        Loja casasBahia = new Loja();
        Loja kabum = new Loja();
        Loja pontoFrio = new Loja();

        long start = System.currentTimeMillis();
        System.out.println(americanas.getPreco());
        System.out.println(casasBahia.getPreco());
        System.out.println(kabum.getPreco());
        System.out.println(pontoFrio.getPreco());
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

        start = System.currentTimeMillis();
        Future<Double> precoAsync = americanas.getPrecoAsyncTunado();
        Future<Double> precoAsync1 = casasBahia.getPrecoAsyncTunado();
        Future<Double> precoAsync2 = kabum.getPrecoAsyncTunado();
        Future<Double> precoAsync3 = pontoFrio.getPrecoAsyncTunado();
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

        FutureTest.enrolando();

        try {
            System.out.println(precoAsync.get());
            System.out.println(precoAsync1.get());
            System.out.println(precoAsync2.get());
            System.out.println(precoAsync3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
