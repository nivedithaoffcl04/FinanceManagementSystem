package com.finance;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/finance_db",
                "root",
                "nivi" // change if needed
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}