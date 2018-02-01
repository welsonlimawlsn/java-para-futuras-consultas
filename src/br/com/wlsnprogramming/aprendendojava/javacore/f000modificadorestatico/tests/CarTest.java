package br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes.Car;
import br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes.Print;
import br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes.Truck;

public class CarTest {

    public static void main(String[] args) {

        Car bmw = new Car("BMW", 280, Car.ELETRIC);
        Car audi = new Car("Audi", 275, Car.COMBUSTION);
        Car mercedes = new Car("Mercedes", 290, Car.COMBUSTION);
        Car porsche = new Car("Porsche", 295, Car.COMBUSTION);

        Truck volvo = new Truck("Volvo", 175, 100);

        Print print = new Print(bmw, audi, mercedes, porsche);
        print.getObjects().add(volvo);

        print.printAll();

        Car.setLimitSpeed(220);

        print.printAll();
    }
}
