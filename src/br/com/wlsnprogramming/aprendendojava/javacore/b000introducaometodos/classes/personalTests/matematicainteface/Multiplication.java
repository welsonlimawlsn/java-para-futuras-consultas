package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicainteface;

public class Multiplication implements Operator {
    @Override
    public double result(double... numbers) {
        double multiplication = 1;
        for(double number : numbers)
            multiplication *= number;
        return multiplication;
    }
}
