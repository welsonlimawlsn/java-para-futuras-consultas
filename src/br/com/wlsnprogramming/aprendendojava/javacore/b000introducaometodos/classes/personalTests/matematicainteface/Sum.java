package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicainteface;

public class Sum implements Operator {
    @Override
    public double result(double... numbers) {
        double sum = 0;
        for(double number : numbers)
            sum += number;
        return sum;
    }
}
