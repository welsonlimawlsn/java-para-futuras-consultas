package br.com.wlsnprogramming.aprendendojava.javacore.zj000optional.classes2;

public class Carro {
    private Seguradora seguradora;
    private String modelo;

    public String getNomeSeguradora(Pessoa pessoa) {
        if(pessoa != null) {
            Carro carro = pessoa.getCarro();
            if(carro != null) {
                Seguradora seguradora = carro.getSeguradora();
                if(seguradora != null) {
                    return seguradora.getNome();
                }
            }
        }
        return "";
    }

    public Seguradora getSeguradora() {
        return seguradora;
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
