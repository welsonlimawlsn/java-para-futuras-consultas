package br.com.wlsnprogramming.aprendendojava.util;

import java.util.Random;

public class CPF {

    public static boolean isValid(String cpf) {
        int[] numeros = extraiNumeros(cpf);
        if (numeros != null && verificaNumerosConhecidos(numeros)) {
            if (geraDigito(1, numeros) != numeros[9]) {
                return false;
            }
            if (geraDigito(2, numeros) != numeros[10]) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static int[] extraiNumeros(String cpf) {
        if (cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
        } else if (cpf.length() != 11) {
            return null;
        }
        int[] arrayint = new int[11];
        for (int i = 0; i < cpf.length(); i++) {
            arrayint[i] = Character.getNumericValue(cpf.toCharArray()[i]);
        }
        return arrayint;
    }

    private static boolean verificaNumerosConhecidos(int[] numeros) {
        int numerosRepetidos = 0;
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == numeros[i - 1]) {
                numerosRepetidos++;
            } else {
                i = numeros.length;
            }
        }
        if (numerosRepetidos == 10) {
            return false;
        }
        return true;
    }

    public static String generate() {
        Random random = new Random();
        int[] numeros = new int[11];
        for (int i = 0; i < 9; i++) {
            numeros[i] = random.nextInt(10);
        }
        numeros[9] = geraDigito(1, numeros);
        numeros[10] = geraDigito(2, numeros);
        StringBuilder cpfString = new StringBuilder();
        for (int numero : numeros) {
            if (cpfString.length() == 3 || cpfString.length() == 7) {
                cpfString.append(".");
            }
            if (cpfString.length() == 11) {
                cpfString.append("-");
            }
            cpfString.append(numero);
        }
        return cpfString.toString();
    }

    private static int geraDigito(int digito, int[] numeros) {
        int resultado = 0;
        int indiceCpf = 0;
        int resto = 0;
        if (digito == 1) {
            for (int i = 10; i >= 2; i--) {
                resultado += numeros[indiceCpf] * i;
                indiceCpf++;
            }
            resto = (resultado * 10) % 11 == 10 ? 0 : (resultado * 10) % 11;
            digito = resto;
        } else if (digito == 2) {
            for (int i = 11; i >= 2; i--) {
                resultado += numeros[indiceCpf] * i;
                indiceCpf++;
            }
            resto = (resultado * 10) % 11 == 10 ? 0 : (resultado * 10) % 11;
            digito = resto;
        }
        return digito;
    }
}
