package br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.predicate;

import br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zg000comportamentoporparametro.intefaces.CarroPredicate;

public class FiltrarCarroPorCor implements CarroPredicate {

    private String cor;

    public FiltrarCarroPorCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean test(Carro carro) {
        return carro.getCor().equalsIgnoreCase(cor);
    }
}
