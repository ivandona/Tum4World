package it.unitn.disi.progetto;

import java.sql.*;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/tumb-db";
    private static final String JDBC_USERNAME = "APP";
    private static final String JDBC_PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
}
