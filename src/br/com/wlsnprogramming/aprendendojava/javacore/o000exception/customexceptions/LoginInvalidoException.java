package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.customexceptions;

public class LoginInvalidoException extends Exception {

    public LoginInvalidoException() {
        super("Usuário ou senha invalido!");
    }
}
