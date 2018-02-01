package br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes;

public class RelatorioPagamento {

    public static void relatorioPagamento(Funcionario funcionario){
        System.out.println("Gerando relatório de pagamento:");
        funcionario.calcularPagamento();
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário desse mes: " + funcionario.getSalario());
        if(funcionario instanceof Gerente) {
            Gerente gerente = (Gerente) funcionario;
            System.out.println("Participação nos lucros: " + gerente.getPnl());
        } else if(funcionario instanceof Vendedor) {
            System.out.println("Total de vendas: " + ((Vendedor) funcionario).getTotalVendas());
        }
    }
}
