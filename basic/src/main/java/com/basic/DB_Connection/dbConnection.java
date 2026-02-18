package com.basic.DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/basic",
                "root",
                "root"
            );

            System.out.println("Connected Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}

