package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicaclasseabstract;

public class Multiplication extends Operator {

    public Multiplication(double ... numbers) {
        super(numbers);
    }

    @Override
    public double doAccout() {
        double multiplication = 1;
        for(double number : this.numbers)
            multiplication *= number;
        return multiplication;
    }
}
