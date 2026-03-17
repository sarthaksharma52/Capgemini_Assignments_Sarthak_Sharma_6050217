package crudWithDifferentClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAO {
	
	static Connection con;
	static {
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/employees",
					"sharthaksharma",
					"Sarthak@52"
			);
		}
		catch(Exception err) {
			System.out.println("Error in making Connection");
		}
	}
	
	public static Employee insert(Employee emp) throws Exception{
		
		 
		PreparedStatement ins = con.prepareStatement(
				"INSERT INTO employee VALUES (?, ?, ?, ?, ?)"
		);
		
		ins.setInt(1,emp.getId());
		ins.setString(2, emp.getName());
		ins.setInt(3, emp.getSalary());
		ins.setString(4, emp.getDept());
		ins.setLong(5, emp.getPhone());
		
		int insertedRows = ins.executeUpdate();
		if(insertedRows >= 1) {
			return emp;
		}
		
		return null;
	};
	
	public static List<Employee> read() throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		PreparedStatement pstm = con.prepareStatement("SELECT * FROM employee");
		ResultSet rs = pstm.executeQuery();

		System.out.println("\nEmployees Table:");
		
		

		while(rs.next()) {
			
			Employee emp = new Employee();
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getInt("salary"));
			emp.setDept(rs.getString("department"));
			emp.setPhone(rs.getLong("phone_no"));
			
			empList.add(emp);
			
		}
		
		return empList;
	}
	
	public static Employee update(int id, int salary) throws SQLException {

	    PreparedStatement update = con.prepareStatement(
	            "UPDATE employee SET salary=? WHERE id=?"
	    );

	    update.setInt(1, salary);
	    update.setInt(2, id);

	    int rows = update.executeUpdate();

	    if(rows > 0) {

	        PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM employee WHERE id=?"
	        );

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {
	            Employee emp = new Employee(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getInt("salary"),
	                    rs.getString("department"),
	                    rs.getLong("phone_no")
	            );

	            return emp;
	        }
	    }

	    return null;
	}
	
	public static Employee delete(int id) throws SQLException {

	    PreparedStatement ps = con.prepareStatement(
	            "SELECT * FROM employee WHERE id=?"
	    );

	    ps.setInt(1, id);

	    ResultSet rs = ps.executeQuery();

	    Employee emp = null;

	    if(rs.next()) {
	        emp = new Employee(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("salary"),
	                rs.getString("department"),
	                rs.getLong("phone_no")
	        );
	    }

	    PreparedStatement delete = con.prepareStatement(
	            "DELETE FROM employee WHERE id=?"
	    );

	    delete.setInt(1, id);
	    delete.executeUpdate();

	    return emp;
	}
	
}
