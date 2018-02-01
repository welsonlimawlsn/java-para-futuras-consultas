package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes;

import java.util.Comparator;
import java.util.HashMap;

public class Celular {
    private String nome;
    private String imei;

    public Celular(String nome, String imei) {
        this.nome = nome;
        this.imei = imei;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    //reflexivo = x.equals(x) tem que ser true para tudo que dor diferente de null
    //simetrico = para x e y diferentes de null, se x.equals(y) == true, logo y.equals(x) == true tambem
    //transitividade = para x, y, z diferentes de null, x.equals(y) == true, logo y.equals(x) == true e x.equals(z), logo y.equals(z) tambem é true
    //consistente = x.equals(y) sempre deve retornar o mesmo valor
    //tudo que for comparado com null é false

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(this.getClass() != obj.getClass())
            return false;
        return imei != null && imei.equals(((Celular) obj).getImei());
    }

    //Se x.equals(y) == true, x.hashCode() == y.hashCode()
    //  x.hashCode() == y.hashCode() não necessariamente o equals devera ser true
    // se x.equals(y) == false
    // x.hashCode() != y.hashCode(), x.equals(y) == true;
    @Override
    public int hashCode() {
        return imei != null ? imei.hashCode() : 1;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "nome='" + nome + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
