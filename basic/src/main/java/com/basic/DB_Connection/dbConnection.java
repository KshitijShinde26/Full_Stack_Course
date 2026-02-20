package com.basic.DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

    private static String url = "jdbc:mysql://localhost:3306/basic";
    private static String user = "root";
    private static String password = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
