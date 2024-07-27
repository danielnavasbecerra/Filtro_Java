package com.navas.examen.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // attributes
    private static final String URL = "jdbc:mysql://localhost:3306/sgpzf";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // method to get connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}