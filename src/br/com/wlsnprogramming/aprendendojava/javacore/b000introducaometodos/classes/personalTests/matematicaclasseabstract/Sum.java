package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicaclasseabstract;

public class Sum extends Operator {

    public Sum(double ... numbers){
        super(numbers);
    }

    @Override
    public double doAccout() {
        double sum = 0;
        for (double number : this.numbers)
            sum += number;
        return sum;
    }
}
