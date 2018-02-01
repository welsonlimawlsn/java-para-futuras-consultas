package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.db;

import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.Comprador;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes.MyRowSetListener;
import br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.conn.ConnectionFactory;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDBOld {
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "')";
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            System.out.println("Linhas afetadas: " + statement.executeUpdate(sql));
            System.out.println("Registro inserido com sucesso!");
            ConnectionFactory.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveTransaction() throws SQLException {
        String sql = "INSERT INTO comprador (nome, cpf) VALUES ('Teste 1', 'Teste 1')";
        String sql2 = "INSERT INTO comprador (nome, cpf) VALUES ('Teste 2', 'Teste 2')";
        String sql3 = "INSERT INTO comprador (nome, cpf) VALUES ('Teste 3', 'Teste 3')";
        Connection connection = ConnectionFactory.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            savepoint = connection.setSavepoint("one");
            statement.executeUpdate(sql2);
            if(true)
                throw new SQLException();
            statement.executeUpdate(sql3);
            connection.commit();
            ConnectionFactory.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback(savepoint);
            connection.commit();
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel excluir o registro");
            return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE id = '" + comprador.getId() + "'";
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            System.out.println("Linhas afetadas: " + statement.executeUpdate(sql));
            System.out.println("Registro excluido com sucesso!");
            ConnectionFactory.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `nome`='" + comprador.getNome() + "', `cpf`='" + comprador.getCpf() + "' WHERE `id`='" + comprador.getId() + "'";
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            System.out.println("Linhas afetadas: " + statement.executeUpdate(sql));
            System.out.println("Registro alterado com sucesso!");
            ConnectionFactory.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "SELECT `id`, `nome`, `cpf` FROM `agencia`.`comprador`";
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Comprador> compradores = new ArrayList<>();
            while (resultSet.next()) {
                compradores.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }
            ConnectionFactory.close(connection, statement, resultSet);
            return compradores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String name) {
        String sql = "SELECT `id`, `nome`, `cpf` FROM `agencia`.`comprador` WHERE nome LIKE '" + name + "'";
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Comprador> compradores = new ArrayList<>();
            while (resultSet.next()) {
                compradores.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }
            ConnectionFactory.close(connection, statement, resultSet);
            return compradores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByNamePreparedStatement(String name) {
        String sql = "SELECT `id`, `nome`, `cpf` FROM `agencia`.`comprador` WHERE nome LIKE ?";
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Comprador> compradores = new ArrayList<>();
            while (resultSet.next()) {
                compradores.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }
            ConnectionFactory.close(connection, preparedStatement, resultSet);
            return compradores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectMetaData() {
        String sql = "SELECT * FROM comprador";
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            resultSet.next();

            int quantidadeColunas = resultSetMetaData.getColumnCount();
            System.out.println("Quantidade coluna: " + quantidadeColunas);
            for (int i = 1; i <= quantidadeColunas; i++) {
                System.out.println("Tabela: " + resultSetMetaData.getTableName(i));
                System.out.println("Nome da Coluna: " + resultSetMetaData.getColumnName(i));
                System.out.println("Tamanho da Coluna: " + resultSetMetaData.getColumnDisplaySize(i));
            }
            ConnectionFactory.close(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDriverStatus() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" - Suporta CONCUR_UPDATABLE");
                }
            }

            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" - Suporta CONCUR_UPDATABLE");
                }
            }

            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" - Suporta CONCUR_UPDATABLE");
                }
            }
            ConnectionFactory.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void testTypeScroll() {
        String sql = "SELECT * FROM comprador";
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.last()) {
                System.out.println("Last line: " + new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
                System.out.println("Number of last line: " + resultSet.getRow());
            }

            System.out.println("Returned to first line: " + resultSet.first());
            System.out.println("Number of last line: " + resultSet.getRow());

            resultSet.absolute(4);

            System.out.println("Line 4: " + new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));

            resultSet.relative(-2);

            System.out.println("Line " + resultSet.getRow() + ": " + new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));

            System.out.println(resultSet.isFirst());
            System.out.println(resultSet.isLast());

            resultSet.afterLast();

            while (resultSet.previous()) {
                System.out.println("Line " + resultSet.getRow() + ": " + new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }

            ConnectionFactory.close(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNamesToUpperCase() {
        String sql = "SELECT * FROM comprador";
        Connection connection = ConnectionFactory.getConnection();
        try {

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("updatesAreDetected: " + databaseMetaData.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println("insertsAreDetected: " + databaseMetaData.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println("deletesAreDetected: " + databaseMetaData.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultSet.updateString("nome", resultSet.getString("nome").toUpperCase());
                //resultSet.cancelRowUpdates(); - não é recomendado fazer dois update seguidos, caso necessite e recomendavel usar esse comando primeiro para voltar os valores originais
                resultSet.updateRow();
            }

            resultSet.beforeFirst();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nome"));
            }

            /////////////////////////////////////////////

            resultSet.first();

            resultSet.moveToInsertRow();
            System.out.println(resultSet.getString("nome"));
            resultSet.updateString("nome", "Welson de Lima Teles");
            resultSet.updateString("cpf", "457.999.999-99");
            resultSet.insertRow();

            resultSet.moveToCurrentRow();

            System.out.println("Line " + resultSet.getRow() + ": " + resultSet.getString("nome"));

            ////////////////////////////////


            resultSet.absolute(5);
            resultSet.deleteRow();

            ConnectionFactory.close(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePreparedStatement(Comprador comprador) {

        if (comprador == null || comprador.getId() == null) {
            System.err.println("Não foi possivel atualizar o registro.");
            return;
        }

        String sql = "UPDATE comprador SET nome=?, cpf=? WHERE id=?";
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, comprador.getNome());
            preparedStatement.setString(2, comprador.getCpf());
            preparedStatement.setInt(3, comprador.getId());
            System.out.println(preparedStatement.executeUpdate() + " registro(s) atualizado(s)!");
            ConnectionFactory.close(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> searchByNomeCallableStatement(String nome) {
        String sql = "CALL `agencia`.`SP_GetCompradoresPorNome`(?)";
        Connection connection = ConnectionFactory.getConnection();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, "%" + nome + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }
            ConnectionFactory.close(connection, callableStatement, resultSet);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Comprador> searchByNameRowSet(String name) {
        String sql = "SELECT * FROM comprador WHERE nome LIKE ?";
        JdbcRowSet jdbcRowSet = ConnectionFactory.getRowSetConnection();

        List<Comprador> compradorList = new ArrayList<>();

        try {
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, "%" + name + "%");
            jdbcRowSet.execute();

            while (jdbcRowSet.next()) {
                compradorList.add(new Comprador(jdbcRowSet.getInt("id"), jdbcRowSet.getString("cpf"), jdbcRowSet.getString("nome")));
            }
            ConnectionFactory.close(jdbcRowSet);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updateRowSet(Comprador comprador){
        if(comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o registro: " + comprador);
            return;
        }

        String sql = "SELECT * FROM comprador WHERE id=?";
        JdbcRowSet jrs = ConnectionFactory.getRowSetConnection();
        jrs.addRowSetListener(new MyRowSetListener());
        try {
            jrs.setCommand(sql);
            jrs.setInt(1, comprador.getId());
            jrs.execute();
            if(jrs.next()) {
                System.out.println(jrs.getString("nome"));
                jrs.updateString("nome", comprador.getNome());
                jrs.updateString("cpf", comprador.getCpf());
                jrs.updateRow();
            }

            ConnectionFactory.close(jrs);
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRowSetCached(Comprador comprador){
        if(comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o registro: " + comprador);
            return;
        }

        String sql = "SELECT * FROM comprador WHERE id=?";
        CachedRowSet crs = ConnectionFactory.getRowSetConnectionCached();
        try {
            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();
            if(crs.next()) {
                System.out.println(crs.getString("nome"));
                crs.updateString("nome", comprador.getNome());
                crs.updateString("cpf", comprador.getCpf());
                crs.updateRow();
                crs.acceptChanges();
            }

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
