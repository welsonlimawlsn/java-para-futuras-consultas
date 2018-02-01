package br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.tests;

import br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes.ArquivoDAOImpl;
import br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes.GenericDAO;

public class DAOTest {
    public static void main(String[] args) {
        GenericDAO genericDAO = new ArquivoDAOImpl();
        genericDAO.save();
    }
}
