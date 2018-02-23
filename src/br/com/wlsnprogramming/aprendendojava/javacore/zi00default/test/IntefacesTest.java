package br.com.wlsnprogramming.aprendendojava.javacore.zi00default.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zi00default.interfaces.MyList;

public class IntefacesTest implements MyList {

    public static void main(String[] args) {
        MyList.sort();
        new IntefacesTest().remove();
    }


    @Override
    public void add() {
        System.out.println("Dentro de add");
    }
}
