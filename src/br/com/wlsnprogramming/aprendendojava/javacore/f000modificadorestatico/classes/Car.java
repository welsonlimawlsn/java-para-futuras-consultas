package br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes;

public class Car implements IPrinted {

    private String model;
    private double maxSpeed;
    private static double limitSpeed = 240;
    private int type;
    public static final int COMBUSTION = 0;
    public static final int ELETRIC = 1;

    public Car() {

    }

    public Car(String model, double maxSpeed, int type) {

        this.model = model;
        this.maxSpeed = maxSpeed;
        this.type = type;

    }

    @Override
    public void print(){

        System.out.println("Model: " + model);
        System.out.println("Max speed: " + maxSpeed);
        System.out.println("Limit speed: " + limitSpeed);
        System.out.println("Type: " + type);

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static double getLimitSpeed() {
        return limitSpeed;
    }

    public static void setLimitSpeed(double limitSpeed) {
        Car.limitSpeed = limitSpeed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
