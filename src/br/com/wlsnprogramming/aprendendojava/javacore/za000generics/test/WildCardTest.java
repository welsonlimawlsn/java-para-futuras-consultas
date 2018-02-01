package br.com.wlsnprogramming.aprendendojava.javacore.za000generics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal {
    public  abstract void consultar();
}

class Cachorro extends Animal implements Comparable<Cachorro> {

    @Override
    public void consultar() {
        System.out.println("Consultando Cachorro");
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Cachorro o) {
        return 0;
    }
}

class Gato extends Animal {

    @Override
    public void consultar() {
        System.out.println("Consultando Gato");
    }
}

public class WildCardTest {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};

        consultarAnimal(cachorros);
        consultarAnimal(gatos);

        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro());
        cachorroList.add(new Cachorro());

        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());
        gatoList.add(new Gato());

        System.out.println("=============================================================================");
        List<Animal> animalList = new ArrayList<>();
        animalList.addAll(gatoList);
        animalList.addAll(cachorroList);

        consultarAnimal(animalList);

        System.out.println("=============================================================================");

        consultarAnimal(gatoList);
        consultarAnimal(cachorroList);

        ordernarLista(cachorroList);
    }

    private static void consultarAnimal(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consultar();
        }
    }
    private static void consultarAnimal(List<? extends Animal> animals) {
        for(Animal animal : animals) {
            animal.consultar();
        }
    }
    private static void consultarCachorroList(List<? super Cachorro> cachorros){
        cachorros.add(new Cachorro());
    }

    private static void ordernarLista(List<? extends Comparable> list){
        Collections.sort(list);
    }
}
