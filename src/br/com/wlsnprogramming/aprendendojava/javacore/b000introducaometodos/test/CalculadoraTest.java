package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.test;

import br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.Calculadora;
import br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicainteface.*;

public class CalculadoraTest {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.somaDoisNumeros();
        calculadora.subtraiDoisNumeros();
        calculadora.multiplicaDoisNumero(6, 7);

        System.out.println(calculadora.divideDoisNumero(20,2));

        int[] arrayNumbers = {10, 20, 30, 45, 65};

        System.out.println(calculadora.sumArray(arrayNumbers));
        System.out.println(calculadora.sumVarArgs(10, 20, 30, 45, 65));

        System.out.println(calculadora.doAccount(new Sum(), 1, 3));
        System.out.println(calculadora.doAccount(new Multiplication(), 2, 3));
        System.out.println(calculadora.fazConta(new br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicaclasseabstract.Sum(10, 10)));
        System.out.println(calculadora.fazConta(new br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicaclasseabstract.Multiplication(10, 10)));
    }
}
