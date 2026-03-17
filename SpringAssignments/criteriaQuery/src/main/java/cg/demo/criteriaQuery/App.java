package cg.demo.criteriaQuery;

import cg.demo.entity.AddressDemoEm;

//import java.time.LocalDate;

import cg.demo.entity.Employee;
import cg.demo.entity.EmployeeDemoEm;

//import cg.demo.entity.Department;
//import cg.demo.criteriaQuery.DepartmentEmployeeCount;
//import cg.demo.criteriaQuery.DepartmentEmployeeDetails;
//import cg.demo.criteriaQuery.EmployeeDAO;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        List<Employee> allEmployees = EmployeeDAO.fetchAllEmployees("AIML", "Deepali Dev");
        List<Employee> allEmployees = EmployeeDAO.fetchAllEmployees();

        System.out.println(allEmployees.toString());

        List<DepartmentEmployeeCount> allEmployeeCounts = EmployeeDAO.fetchCountEmployees();
        System.out.println(allEmployeeCounts.toString());

        List<Employee> allEmployeeForDept = EmployeeDAO.fetchRecordsDept("AIML");
        System.out.println(allEmployeeForDept.toString());

        List<DepartmentEmployeeDetails> deptDetails = EmployeeDAO.fetchDeptDetailsByEmployeeId(1);
        System.out.println(deptDetails);
        
        List<Employee> allEmployeesSalaryCriteriaQuery = EmployeeDAO.fetchEmployeesBasedOnSalary(50000);
        System.out.println("All employees according to given salary criteria query: ");
        System.out.println(allEmployeesSalaryCriteriaQuery.toString());
        
     // Implementing Embedded & Embeddable

        EmployeeDemoEm demoEmployee = new EmployeeDemoEm(192, "Rohit Shetty",
                new AddressDemoEm(202192, "Navi Mumbai", "Maharashtra"));

        em.persist(demoEmployee);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}