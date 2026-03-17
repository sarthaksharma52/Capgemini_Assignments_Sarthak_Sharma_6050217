package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Insert {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/employees",
                "sharthaksharma",
                "Sarthak@52"
        );

        // INSERT QUERY
        PreparedStatement insert = con.prepareStatement(
                "INSERT INTO employees (eid, ename, salary, dept, phoneNO) VALUES (?, ?, ?, ?, ?)"
        );

        insert.setInt(1, 107);
        insert.setString(2, "Ashu");
        insert.setDouble(3, 45231.75);
        insert.setString(4, "IT");
        insert.setLong(5, 987654321);

        int rows = insert.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee Mohini inserted successfully!");
        }

        // DISPLAY DATA
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM employees");
        ResultSet rs = pstm.executeQuery();

        System.out.println("\nEmployees Table:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("eid") + "\t" +
                    rs.getString("ename") + "\t" +
                    rs.getDouble("salary") + "\t" +
                    rs.getString("dept") + "\t" +
                    rs.getLong("phoneNO")
            );
        }

        rs.close();
        insert.close();
        pstm.close();
        con.close();
    }
}