
package com.hotel.connection;

import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("MySQL connection successful!");
            System.out.println("Database: " +
                    conn.getCatalog());
        } catch (Exception e) {
            System.out.println("MySQL connection failed!");
            e.printStackTrace();
        }
    }
}
