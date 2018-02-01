package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.test;

import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Comprador;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.db.CompradorDBOld;

import java.sql.SQLException;
import java.util.List;

public class ConnectionTest {
    public static void main(String[] args) {
        //CompradorDBOld.updateNamesToUpperCase();
        //System.out.println("=======================================================================");
        //selecionarTudo();
        //System.out.println(CompradorDBOld.searchByNamePreparedStatement("son"));
        //CompradorDBOld.updatePreparedStatement(new Comprador(1, "147.852.336-78", "Maria Jesus de Lima Menezes"));
        //System.out.println(CompradorDBOld.searchByNomeCallableStatement("son"));
        //System.out.println(CompradorDBOld.searchByNameRowSet("welson"));
        //CompradorDBOld.updateRowSet(new Comprador(1, "147.852.336-78", "Maria Jesus de Lima Menezes"));
        // CompradorDBOld.updateRowSetCached(new Comprador(1, "147.852.336-78", "Maria Jesus de Lima Menezes".toUpperCase()));
        //selecionarTudo();
        try {
            CompradorDBOld.saveTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inserir() {
        Comprador comprador = new Comprador("456.789.474-8", "João");
        CompradorDBOld.save(comprador);
    }

    public static void deletar() {
        Comprador comprador = new Comprador(2, null, null);
        CompradorDBOld.delete(comprador);
    }

    private static void alterar() {
        Comprador comprador = new Comprador(1, "456.123.789-12", "Maria");
        CompradorDBOld.update(comprador);
    }

    private static void selecionarTudo() {
        List<Comprador> compradores = CompradorDBOld.selectAll();
        if (compradores != null)
            for (int i = 1; i <= compradores.size(); i++) {
                System.out.println(i + " - " + compradores.get(i - 1)+"\n" +
                        "-----------------------------------------------------------------");
            }
    }

    private static void bucarPorNome(String nome) {
        List<Comprador> compradores = CompradorDBOld.searchByName(nome);
        if (compradores != null)
            for (Comprador comprador : compradores) {
                System.out.println(comprador);
            }
    }
}
