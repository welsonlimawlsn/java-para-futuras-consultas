package br.com.wlsnprogramming.aprendendojava.javacore.o000exception.checkedexception.test;

import br.com.wlsnprogramming.aprendendojava.javacore.o000exception.customexceptions.LoginInvalidoException;

public class CustomExceptionTest {

    public static void main(String[] args) {
        try {
            logar("welson", "1235456789");
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar(String user, String password) throws LoginInvalidoException {
        String usuario = "welson";
        String senha = "123456789";

        if(user.equals(usuario) && password.equals(senha)) {
            System.out.println("Usuario logado!");
        } else {
            throw new LoginInvalidoException();
        }
    }
}
