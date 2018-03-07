package br.com.wlsnprogramming.aprendendojava.javacore.zl000streamsparalelos.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParalelosTest1 {
    public static void main(String[] args) {
        long number = 10_000_000_000L;
        somaFor(number);
        //somaStream(number);
        //somaParallelStream(number);
        somaRangeClosedStream(number);
        somaRangeClosedParallelStream(number);
        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
    }

    private static void somaFor(long number) {
        System.out.println("For");
        long result = 0;
        long init = System.currentTimeMillis();
        for(long i = 1L; i < number; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void somaStream(long number) {
        System.out.println("Stream Sequencial");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(number).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void somaParallelStream(long number) {
        System.out.println("Stream Paralelo");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(number).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void somaRangeClosedStream(long number) {
        System.out.println("Stream Range Closed");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, number).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void somaRangeClosedParallelStream(long number) {
        System.out.println("Stream Range Closed");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, number).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + "ms");
    }
}
