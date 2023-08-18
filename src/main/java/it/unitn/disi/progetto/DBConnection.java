package it.unitn.disi.progetto;

import java.sql.*;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/your-database-name";
    private static final String JDBC_USERNAME = "your-username";
    private static final String JDBC_PASSWORD = "your-password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
}
