package br.com.wlsnprogramming.aprendendojava.javacore.p000assertions.tests;

public class AssertTest {

    public static void main(String[] args) {
        calcularSalario(-10);
    }

    private static void calcularSalario(double salario){
        assert salario > 0 : "O salario não deve ser menor do que zero, o valor do salário atual é " + salario;
        System.out.println("calculando salario");
    }

    private static void calculaSalario(double salario) {
        if(salario < 0 ) {
            throw new IllegalArgumentException("Insira um salário maior que 0");
        }
    }
    public static void diasSemana(int dia) {
        switch (dia) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                assert false;
        }
    }
}
