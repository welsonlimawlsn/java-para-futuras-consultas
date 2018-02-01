package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.db;

import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Comprador;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO {
    public static void save(Comprador comprador) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comprador (nome, cpf) VALUES (?, ?)")) {
            preparedStatement.setString(1, comprador.getNome());
            preparedStatement.setString(2, comprador.getCpf());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel excluir esse registro. Comprador é nulo, ou as informações estão incompletas");
            return;
        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM comprador WHERE id = ?")) {
            preparedStatement.setInt(1, comprador.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel excluir esse registro. Comprador é nulo, ou as informações estão incompletas");
            return;
        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE comprador SET nome = ?, cpf = ? WHERE id = ?")) {
            preparedStatement.setString(1, comprador.getNome());
            preparedStatement.setString(2, comprador.getCpf());
            preparedStatement.setInt(3, comprador.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> listAll() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comprador");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Comprador> compradorList = new ArrayList<>();
            while (resultSet.next()) {
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String name) {
        ResultSet resultSet = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comprador WHERE nome LIKE ?")) {
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            List<Comprador> compradorList = new ArrayList<>();
            while (resultSet.next()) {
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return null;
    }

    public static Comprador searchById(Integer id) {
        ResultSet resultSet = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comprador WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return null;
    }
}
