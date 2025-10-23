package com.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static Connection connection;

    public static Connection getConnection() {
        try {

            if (connection != null && !connection.isClosed()) {
                return connection;
            }
            
            String url = "jdbc:mysql://localhost:3306/university?serverTimezone=UTC&useSSL=false";
            String user = "readonly_user";
            String password = "securepass123";
            connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static void setConnection(Connection conn) {
        connection = conn;
    }
}
