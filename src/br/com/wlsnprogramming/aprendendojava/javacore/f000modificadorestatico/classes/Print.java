package br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print {

    private List<IPrinted> objects;

    {
        objects = new ArrayList<>();
    }

    public Print(){

    }

    public Print(IPrinted... printeds){

        for(IPrinted object : printeds) {

            objects.add(object);
        }
    }

    public void printAll(){

        for (IPrinted object : objects) {

            System.out.println("-----------------------------------");
            object.print();
        }
    }

    public List<IPrinted> getObjects() {
        return objects;
    }

    public void setObjects(List<IPrinted> objects) {
        this.objects = objects;
    }
}
