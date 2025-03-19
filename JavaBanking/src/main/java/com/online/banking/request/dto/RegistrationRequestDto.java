package com.online.banking.request.dto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationRequestDto {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/banking";
        String user = "root";
        String password = "root";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a sample query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println("Column 1: " + resultSet.getString(1));
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}




