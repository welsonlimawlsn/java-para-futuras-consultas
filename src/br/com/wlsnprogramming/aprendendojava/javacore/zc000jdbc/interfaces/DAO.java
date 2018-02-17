package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.interfaces;

import java.util.List;

public interface DAO<T> {

    void save(T t);

    void delete(T t);

    void update(T t);

    List<T> listAll();

    List<T> searchByName(String name);
}
