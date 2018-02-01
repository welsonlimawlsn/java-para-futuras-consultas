package br.com.wlsnprogramming.aprendendojava.basico.fluxos;

public class ExercicioControleFluxo {
    public static void main(String[] args) {
        float salario = 1190;
        float imposto;

        if(salario < 1000){
            imposto = salario / 100f * 5f;
        } else if(salario < 2000){
            imposto = salario / 100f * 10f;
        } else if(salario < 4000){
            imposto = salario / 100f * 15f;
        } else {
            imposto = salario / 100f * 20f;
        }
        System.out.println("Com o salário de R$ " + salario + ", o imposto será de R$ " + imposto);
    }
}
