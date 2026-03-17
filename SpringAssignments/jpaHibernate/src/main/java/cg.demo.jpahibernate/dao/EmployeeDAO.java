package cg.demo.jpahibernate.dao;

//package cg.demo.dao;

import java.sql.SQLException;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	private static EntityManager em = emf.createEntityManager();;

	public static void insertEmployee(Employee emp) {
		em.getTransaction().begin();
		em.persist(emp);// insertion
		em.getTransaction().commit();

	}

	public static Employee viewEmployeesWithId(int id) throws SQLException {
		Employee result = null;
		em.getTransaction().begin();
		result = em.find(Employee.class, id);

		em.getTransaction().commit();

		return result;
	}

	public static Employee updateEmployee(int id, float salary) {
		Employee result;
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		emp.setSalary(salary);
		System.out.println(em.merge(emp));

		result = em.find(Employee.class, id);
		em.getTransaction().commit();

		return result;
	}

	public static Employee deleteEmployee(int id) {
		em.getTransaction().begin();
		Employee result = em.find(Employee.class, id);
		if (result != null) {
			em.remove(result);
		}
		em.getTransaction().commit();

		return result;
	}

}