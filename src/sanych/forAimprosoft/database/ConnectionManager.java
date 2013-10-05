package sanych.forAimprosoft.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance = new ConnectionManager();

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3307/departament";
    String user = "root";
    String password = "P@ssw0rd321";

    private ConnectionManager() {}

    public Connection getConnection() {
        Connection c;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException|ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return c;
    }

    public void releaseConnection(Connection connection) {
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ConnectionManager getInstance() {
        return instance;
    }
}
