package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes.AviaoSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AviaoSingletonTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        agendarAssento("1A");
        agendarAssento("1A");
        AviaoSingleton aviaoSingleton = AviaoSingleton.getInstance();
        AviaoSingleton aviaoSingleton1 = null;

        Constructor[] constructors = AviaoSingleton.class.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            constructor.setAccessible(true);
            aviaoSingleton1 = (AviaoSingleton) constructor.newInstance();
            break;
        }

        System.out.println(aviaoSingleton.hashCode());
        System.out.println(aviaoSingleton1.hashCode());
    }

    private static void agendarAssento(String assento) {
        AviaoSingleton aviaoSingleton = AviaoSingleton.getInstance();
        System.out.println(aviaoSingleton.bookAssento(assento));
    }
}
