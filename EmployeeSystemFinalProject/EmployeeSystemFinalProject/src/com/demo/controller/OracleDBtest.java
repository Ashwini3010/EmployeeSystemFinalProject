package com.demo.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBtest {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "c##hr";
        String password = "hr";

        try {
            // Load Oracle JDBC Driver (optional for Java 7+)
            Class.forName("oracle.jdbc.OracleDriver");

            // Establish Connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection Successful!");
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}

