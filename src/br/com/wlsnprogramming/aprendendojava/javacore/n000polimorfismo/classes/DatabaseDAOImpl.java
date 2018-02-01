package br.com.wlsnprogramming.aprendendojava.javacore.n000polimorfismo.classes;

public class DatabaseDAOImpl implements GenericDAO {
    @Override
    public void save() {
        System.out.println("Salvando dados no banco de bados");
    }
}
