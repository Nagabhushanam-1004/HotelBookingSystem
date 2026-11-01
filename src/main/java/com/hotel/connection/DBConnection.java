
package com.hotel.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/hotel_db";

    private static final String USERNAME = "root";

    // Replace with your actual MySQL password
    private static final String PASSWORD = "My_sql_password";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                URL, USERNAME, PASSWORD);
    }
}
