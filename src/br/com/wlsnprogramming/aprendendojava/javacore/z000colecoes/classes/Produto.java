package br.com.wlsnprogramming.aprendendojava.javacore.z000colecoes.classes;

public class Produto implements Comparable<Produto> {

    private String numeroSerial;
    private String nome;
    private double preco;//Trocar para classes Wrappers para usar o método compareTo()
    private int quantidade;

    public Produto(String numeroSerial, String nome, double preco) {
        this.numeroSerial = numeroSerial;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String numeroSerial, String nome, double preco, int quantidade) {
        this.numeroSerial = numeroSerial;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return numeroSerial != null ? numeroSerial.equals(produto.numeroSerial) : produto.numeroSerial == null;
    }

    @Override
    public int hashCode() {
        return numeroSerial != null ? numeroSerial.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "numeroSerial='" + numeroSerial + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public int compareTo(Produto o) {

        //negativo se esse objeto < outro objeto
        //zero se esssa objeto == outro objeto
        //poisitivo se esse objeto > outro objeto


        //return ((Double) preco).compareTo(o.getPreco());

        return Double.compare(preco, o.getPreco());
    }
}
