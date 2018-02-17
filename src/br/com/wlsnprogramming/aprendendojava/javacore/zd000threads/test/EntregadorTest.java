package br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.test;

        import br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.classes.Entregador;
        import br.com.wlsnprogramming.aprendendojava.javacore.zd000threads.classes.ListaMembros;

        import javax.swing.*;

public class EntregadorTest {
    public static void main(String[] args) {
        ListaMembros listaMembros = new ListaMembros();
        Thread thread = new Thread(new Entregador(listaMembros), "Entregador 1");
        Thread thread1 = new Thread(new Entregador(listaMembros), "Entregador 2");

        thread.start();
        thread1.start();

        while (true) {
            String email = JOptionPane.showInputDialog("Digite o email do membro: ");
            if(email == null || email.isEmpty()) {
                listaMembros.fecharLista();
                break;
            }
            listaMembros.addEmailMembro(email);
        }
    }
}
