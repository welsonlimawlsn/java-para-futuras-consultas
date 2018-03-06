package br.com.wlsnprogramming.aprendendojava.javacore.zk000streams.test;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5GerandoStreams {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println("\n=====================================================");
        IntStream.range(1, 100).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Stream<String> stringStream = Stream.of("Welson", "de", "Lima", "Teles");
        stringStream.map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
        Stream<String> empty = Stream.empty();

        int[] numeros = {1, 2, 3, 4, 5, 6};
        OptionalDouble average = Arrays.stream(numeros).average();
        System.out.println(average.getAsDouble());

        try (Stream<String> lines = Files.lines(Paths.get("Teste.txt"), Charset.defaultCharset())) {
            lines.flatMap(line -> Arrays.stream(line.split("\n"))).filter(p -> p.contains("W")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream.iterate(1, n -> n + 2).limit(100).forEach(System.out::println);
        // 0,1,1,2,3,5,8,13,21,34...

        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(10).forEach(f -> System.out.println(Arrays.toString(f)));

        Stream.iterate(new  int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(10).map(t -> t[0]).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Stream.generate(() -> threadLocalRandom.nextInt(1, 61)).limit(6).forEach(System.out::println);
    }
}
