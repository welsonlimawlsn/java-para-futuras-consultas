package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.db;

import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Carro;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    public static void save(Carro carro) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO carro (modelo, placa, id_comprador) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, carro.getNome());
            preparedStatement.setString(2, carro.getPlaca());
            preparedStatement.setInt(3, carro.getComprador().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possivel excluir esse registro. Carro é nulo, ou as informações estão incompletas");
            return;
        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM carro WHERE id=?")) {
            preparedStatement.setInt(1, carro.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possivel excluir esse registro. Carro é nulo, ou as informações estão incompletas");
            return;
        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE carro SET modelo = ?, placa = ? WHERE id=?")) {
            preparedStatement.setString(1, carro.getNome());
            preparedStatement.setString(2, carro.getPlaca());
            preparedStatement.setInt(3, carro.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Carro> listAll() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM carro");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Carro> carroList = new ArrayList<>();
            while (resultSet.next()) {
                carroList.add(new Carro(resultSet.getInt("id"), resultSet.getString("modelo"), resultSet.getString("placa"), CompradorDAO.searchById(resultSet.getInt("id_comprador"))));
            }
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Carro> searchByName(String name) {
        ResultSet resultSet = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM carro WHERE modelo LIKE ?")) {
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            List<Carro> carroList = new ArrayList<>();
            while (resultSet.next()) {
                carroList.add(new Carro(resultSet.getInt("id"), resultSet.getString("modelo"), resultSet.getString("placa"), CompradorDAO.searchById(resultSet.getInt("id_comprador"))));
            }
            return carroList;
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
