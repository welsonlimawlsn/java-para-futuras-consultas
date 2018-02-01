package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicaclasseabstract;

public abstract class Operator {

    protected double[] numbers;

    protected Operator(double ... numbers){
        this.numbers = numbers;
    }

    public abstract double doAccout();
}
