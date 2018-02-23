package br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes;

import java.util.Optional;

public class Carro {
    private Seguradora seguradora;
    private String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public Carro(Seguradora seguradora, String modelo) {
        this.seguradora = seguradora;
        this.modelo = modelo;
    }

    public Optional<Seguradora> getSeguradora() {
        return Optional.ofNullable(seguradora);
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
