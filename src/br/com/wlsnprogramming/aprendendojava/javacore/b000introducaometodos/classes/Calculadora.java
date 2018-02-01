package br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes;

import br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicainteface.Operator;

public class Calculadora {

    public void somaDoisNumeros() {
        System.out.println(5 + 5);
    }

    public void subtraiDoisNumeros() {
        System.out.println(5 - 5);
    }

    public void multiplicaDoisNumero(int numero1, int numero2) {
        System.out.println(numero1 * numero2);
    }

    public double divideDoisNumero(double numero1, double numero2) {
        if (numero1 != 0)
            return numero1 / numero2;
        return -1;
    }

    public void imprimeDoisNumerosDivididos(double numero1, double numero2) {
        if (numero2 == 0)
            return;
        System.out.println(numero1 / numero2);
    }

    public void alteraDoisNumeros(int numero1, int numero2){
        numero1 = 30;
        numero2 = 40;
    }

    public int sumArray(int[] numbers){
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
    public int sumVarArgs(int ... numbers){
        return sumArray(numbers);
        /*int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;*/
    }

    public double doAccount(Operator operator, double ... numbers) {
        return operator.result(numbers);
    }

    public double fazConta(br.com.wlsnprogramming.aprendendojava.javacore.b000introducaometodos.classes.personalTests.matematicaclasseabstract.Operator operator){
        return operator.doAccout();
    }
}
