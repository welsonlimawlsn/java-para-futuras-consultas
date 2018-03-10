package br.com.wlsnprogramming.aprendendojava.javacore.zm000completablefuture.classes;

public class Orcamento {
    private final String nomeLoja;
    private final double preco;
    private final Desconto.Codigo codigoDesconto;

    private Orcamento(String nomeLoja, double preco, Desconto.Codigo codigoDesconto) {
        this.nomeLoja = nomeLoja;
        this.preco = preco;
        this.codigoDesconto = codigoDesconto;
    }

    public static Orcamento parse(String s) {
        String[] info = s.split(":");
        return new Orcamento(info[0], Double.parseDouble(info[1]), Desconto.Codigo.valueOf(info[2]));
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public double getPreco() {
        return preco;
    }

    public Desconto.Codigo getCodigoDesconto() {
        return codigoDesconto;
    }
}
