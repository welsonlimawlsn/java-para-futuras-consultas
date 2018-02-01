package br.com.wlsnprogramming.aprendendojava.javacore.f000modificadorestatico.classes;

public class Truck implements IPrinted {

    private String model;
    private double maxSpeed;
    private double maxWeightSupported;

    public Truck() {

    }

    public Truck(String model, double maxSpeed, double maxWeightSupported) {

        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxWeightSupported = maxWeightSupported;
    }

    @Override
    public void print() {

        System.out.println("Model: " + model);
        System.out.println("Max speed: " + maxSpeed);
        System.out.println("Max weight supported: " + maxWeightSupported);
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

    public double getMaxWeightSupported() {
        return maxWeightSupported;
    }

    public void setMaxWeightSupported(double maxWeightSupported) {
        this.maxWeightSupported = maxWeightSupported;
    }
}
