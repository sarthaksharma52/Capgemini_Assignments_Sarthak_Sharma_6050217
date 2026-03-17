package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Update {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/employees",
                "sharthaksharma",
                "Sarthak@52"
        );

        // UPDATE QUERY
        PreparedStatement update = con.prepareStatement(
                "UPDATE employees SET salary=? WHERE ename=?"
        );

        update.setDouble(1, 70000.50);
        update.setString(2, "Ashu");

        int rows = update.executeUpdate();

        if (rows > 0) {
            System.out.println("Ashu salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }

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
        update.close();
        pstm.close();
        con.close();
    }
}