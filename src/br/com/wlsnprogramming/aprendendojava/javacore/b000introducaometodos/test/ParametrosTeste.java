package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.test;

import br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.Calculadora;

public class ParametrosTeste {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int num1 = 5;
        int num2 = 10;
        calculadora.alteraDoisNumeros(num1, num2);
    }
}
