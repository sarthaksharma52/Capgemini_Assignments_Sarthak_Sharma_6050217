package com.demo.jdbc;

import java.sql.*;
import java.util.*;

class Employee{
	int eid;
	String ename;
	int salary;
	String dept;
	long phoneNo;

	Employee(int eid, String ename, int salary, String dept, long phoneNo){
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.dept = dept;
		this.phoneNo = phoneNo;
	}
		
}

public class CRUD {

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/employees",
				"sharthaksharma",
				"Sarthak@52"
		);

		Scanner sc = new Scanner(System.in);

		System.out.println("\n1. Insert Employee");
		System.out.println("2. Read Employees");
		System.out.println("3. Update Salary");
		System.out.println("4. Delete Employee");

		System.out.print("Enter choice: ");
		int action = sc.nextInt();

		switch(action) {

		case 1: {

			System.out.print("Enter ID: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Name: ");
			String name = sc.nextLine();

			System.out.print("Enter Salary: ");
			int salary = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Dept: ");
			String dept = sc.nextLine();

			System.out.print("Enter Phone: ");
			long phone = sc.nextLong();

			PreparedStatement insert = con.prepareStatement(
					"INSERT INTO employees VALUES (?, ?, ?, ?, ?)"
			);

			insert.setInt(1,id);
			insert.setString(2,name);
			insert.setInt(3,salary);
			insert.setString(4,dept);
			insert.setLong(5,phone);

			int rows = insert.executeUpdate();

			if(rows>0)
				System.out.println("Employee inserted successfully");

			insert.close();

			break;
		}

		case 2: {

			PreparedStatement pstm = con.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstm.executeQuery();

			System.out.println("\nEmployees Table:");

			while(rs.next()) {
				System.out.println(
						rs.getInt("eid") + "\t" +
						rs.getString("ename") + "\t" +
						rs.getInt("salary") + "\t" +
						rs.getString("dept") + "\t" +
						rs.getLong("phoneNO")
						);
			}

			rs.close();
			pstm.close();

			break;
		}

		case 3: {

			System.out.print("Enter employee name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Enter new salary: ");
			int salary = sc.nextInt();

			PreparedStatement update = con.prepareStatement(
					"UPDATE employees SET salary=? WHERE ename=?"
			);

			update.setInt(1,salary);
			update.setString(2,name);

			int rows = update.executeUpdate();

			if(rows>0)
				System.out.println("Salary updated successfully");
			else
				System.out.println("Employee not found");

			update.close();

			break;
		}

		case 4: {

			System.out.print("Enter employee name to delete: ");
			sc.nextLine();
			String name = sc.nextLine();

			PreparedStatement delete = con.prepareStatement(
					"DELETE FROM employees WHERE ename=?"
			);

			delete.setString(1,name);

			int rows = delete.executeUpdate();

			if(rows>0)
				System.out.println("Employee deleted successfully");
			else
				System.out.println("Employee not found");

			delete.close();

			break;
		}

		default:
			System.out.println("Invalid choice");
		}

		con.close();
		sc.close();
	}
}