package com.senderz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/senderz";
        String rootUsername = "root";
        String rootPassword = "root";

        try (Connection rootConnection = DriverManager.getConnection(url, rootUsername, rootPassword);
             Statement statement = rootConnection.createStatement()) {
            System.out.println("Connect to DB successfully !");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
