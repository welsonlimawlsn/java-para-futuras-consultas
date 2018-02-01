package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.conn;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class ConnectionFactory {
    //java.sql - Connection, Statement, ResultSet
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/agencia";
        String user = "root";
        String password = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:mysql://localhost:3306/agencia";
        String user = "root";
        String password = null;

        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            //jdbcRowSet.setPassword(password);
            return jdbcRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CachedRowSet getRowSetConnectionCached() {
        String url = "jdbc:mysql://localhost:3306/agencia?relaxAutoCommit=true";
        String user = "root";
        String password = null;

        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            //jdbcRowSet.setPassword(password);
            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(RowSet rowSet) {
        try {
            if (rowSet != null)
                rowSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection);
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection, statement);
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
