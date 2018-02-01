package br.com.wlsnprogramming.aprendendojava.javacore.k000enum.classes;

public enum TipoCliente {
//                                     constant specific class body
    PESSOA_FISICA(1, "Pessoa fisica"), PESSOA_JURIDICA(2, "Pessoa juridica"){
        @Override
        public String getId() {
            return "B";
        }
    };

    private int tipo;
    private String descricao;

    TipoCliente(int tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getId() {
        return "A";
    }
}
