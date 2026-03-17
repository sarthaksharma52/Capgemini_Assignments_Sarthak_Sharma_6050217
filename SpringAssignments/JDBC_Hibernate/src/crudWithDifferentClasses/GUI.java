package crudWithDifferentClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

class Employee{
	private int id;
	private String name;
	private int salary;
	private String dept;
	private long phone;
	
	Employee(){
		
	}
	
	Employee(int id,String name,int salary,String dept,long phone){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}

public class GUI {
	public static void main(String[] args) throws Exception{
		
		Class.forName("org.postgresql.Driver");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			boolean flag = true;
			System.out.println("\n1. Insert Employee");
			System.out.println("2. Read Employees");
			System.out.println("3. Update Salary");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choise");
			int choice = sc.nextInt();
			switch(choice) {
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
					
					Employee iemp = DAO.insert(new Employee(id,name,salary,dept,phone));
					
					System.out.println(iemp.getId()+ " " + iemp.getName() + " " + iemp.getSalary() + " " + iemp.getDept() + " " + iemp.getPhone());

					
					break;
				}
				case 2: {

					System.out.println("\nEmployees Table:");
					List<Employee> emp = new ArrayList<>();
					emp = DAO.read();
					
					for(int i=0;i<emp.size();i++) {
						System.out.println(emp.get(i).getId()+ " " + emp.get(i).getName()+ " " +emp.get(i).getSalary()+ " " + emp.get(i).getDept() + " " + emp.get(i).getPhone());					}
					break;
				}
				case 3: {
					System.out.println("\nEmployees Updated Detail:");
					
					System.out.println("Enter the id of salary");
					int empId = sc.nextInt();
					System.out.println("Enter the updated salary of employee");
					int sal = sc.nextInt();
					
					Employee uemp = DAO.update(empId,sal);
					
					System.out.println(uemp.getId()+ " " + uemp.getName() + " " + uemp.getSalary() + " " + uemp.getDept() + " " + uemp.getPhone());
					break;
				}
				case 4: {
					System.out.println("\nDelited Employee:");
					
					System.out.println("Enter the id of employee you want to delete");
					int id = sc.nextInt();
					
					Employee demp = DAO.delete(id);
					
					System.out.println(demp.getId()+ " " + demp.getName() + " " + demp.getSalary() + " " + demp.getDept() + " " + demp.getPhone());
					break;
				}
				case 5:{
					
					flag = false;
					break;
				}
				
			}
			
			if(!flag) {
				break;
			}
			
		}
		
		System.out.println("end");
	}
	
}
