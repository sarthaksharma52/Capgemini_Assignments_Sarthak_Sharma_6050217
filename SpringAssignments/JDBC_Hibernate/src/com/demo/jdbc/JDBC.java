package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBC {

    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/employees",
                "sharthaksharma",
                "Sarthak@52"
        );

//        Statement stmt = conn.createStatement();
//
//        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
        
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM employees");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt("eid") + "\t" + rs.getString("ename") + "\t" + rs.getInt("salary"));
        }
        rs.close();
        String name = "Tripti";
        
        PreparedStatement pstm1 = con.prepareStatement("delete from employees where ename=?");
        pstm1.setString(1,name);
        
        int rowAffected = pstm1.executeUpdate();
        if(rowAffected>=1) {
        	System.out.println("Deleted record Successfully for name" + name);
        }
        else {
        	System.err.println("Deletion Error!!!");
        }
        pstm1.close();
        pstm.close();
        con.close();
    }
}