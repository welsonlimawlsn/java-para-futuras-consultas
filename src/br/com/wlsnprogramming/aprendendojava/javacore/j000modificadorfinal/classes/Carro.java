package br.com.wlsnprogramming.aprendendojava.javacore.j000modificadorfinal.classes;

public final class Carro {

    private String modelo;
    public final Comprador COMPRADOR = new Comprador();
    private String fabricante;
    public static final double VELOCIDADE_LIMITE = 200;

    public final void imprimir() {
        System.out.println(toString());
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
