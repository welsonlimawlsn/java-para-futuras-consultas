package br.com.wlsnprogramming.aprendendojava.javacore.g000associacao.classes.exercicios;

public class Local {

    private String rua;
    private String bairro;

    public Local() {
    }

    public Local(String rua, String bairro) {
        this.rua = rua;
        this.bairro = bairro;
    }

    public void imprimir() {
        System.out.println("Rua: " + rua);
        System.out.println("Bairro: " + bairro);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return rua + " - " + bairro;
    }
}
