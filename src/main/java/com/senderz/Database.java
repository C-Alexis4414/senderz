package com.senderz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String rootUsername = "root";
        String rootPassword = "root";

        try (Connection rootConnection = DriverManager.getConnection(url, rootUsername, rootPassword);
             Statement rootStatement = rootConnection.createStatement()) {
            String createDatabaseSQL = "CREATE DATABASE senderz";
            rootStatement.executeUpdate(createDatabaseSQL);
            String createUserSQL = "CREATE USER 'root'@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION; FLUSH PRIVILEGES";
            rootStatement.executeUpdate(createUserSQL);
            String grantPrivilegesSQL = "GRANT ALL PRIVILEGES ON senderz.* TO 'root'@'localhost'";
            rootStatement.executeUpdate(grantPrivilegesSQL);
            System.out.println("Database and user created with success !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
