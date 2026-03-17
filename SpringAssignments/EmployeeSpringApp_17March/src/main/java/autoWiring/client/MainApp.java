package SpringAssignments.EmployeeSpringApp_17March.src.main.java.autoWiring.client;

import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import autoWiring.SpringConf;
import autoWiring.repository.Employee;
import autoWiring.service.EmployeeService;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConf.class);

        EmployeeService service = context.getBean(EmployeeService.class);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n====== EMPLOYEE MANAGEMENT SYSTEM ======");
            System.out.println("1. Fetch Employee By ID");
            System.out.println("2. Fetch All Employees");
            System.out.println("3. Create Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    Employee emp = service.getEmployeeById(id);

                    if(emp != null) {
                        System.out.println("\nEmployee Info");
                        System.out.println("ID: " + emp.getId());
                        System.out.println("Name: " + emp.getName());
                        System.out.println("Salary: " + emp.getSalary());
                    } else {
                        System.out.println("Employee Not Found");
                    }

                    break;

                case 2:

                    Map<Integer, Employee> employees = service.getAllEmployees();

                    System.out.println("\nAll Employees:");

                    employees.forEach((k,v)->{
                        System.out.println(v.getId()+" "+v.getName()+" "+v.getSalary());
                    });

                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    int cid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double csalary = sc.nextDouble();

                    service.createEmployee(new Employee(cid,cname,csalary));

                    System.out.println("Employee Added Successfully");

                    break;

                case 4:

                    System.out.print("Enter Employee ID to Update: ");
                    int uid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double usalary = sc.nextDouble();

                    service.updateEmployee(new Employee(uid,uname,usalary));

                    System.out.println("Employee Updated Successfully");

                    break;

                case 5:

                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();

                    service.deleteEmployee(did);

                    System.out.println("Employee Deleted Successfully");

                    break;

                case 6:

                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while(choice != 6);

        sc.close();
    }
}