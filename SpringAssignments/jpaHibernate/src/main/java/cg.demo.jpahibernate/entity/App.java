package entity;

/**
 * Hello world!
 *
 */
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class App {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
//
//        EntityManager em = emf.createEntityManager();
//
//        Employee e = new Employee();
//
//        e.setId(45);
//        e.setEname("Rahul");
//        e.setDept("IT");
//        e.setSalary(50000);
//        e.setPhoneNO(987654321);
//
//        em.getTransaction().begin();
//
//        em.persist(e);
//
//        Employee newEmp = em.find(Employee.class, 101);
//
//        if (newEmp != null) {
//            System.out.println("Employee found: " + newEmp.getEname());
//        } else {
//            System.out.println("Employee not found");
//        }
//
//        // only merge method, select query is there
//        // manually called find method, one select st is needed to be there
//        // for merge, another select st not generated
//
//        em.getTransaction().commit();
//
//        System.out.println("Employee inserted successfully");
//
//        em.close();
//        emf.close();
//    }
//}




import dao.EmployeeDAO;

public class App {

    public static void main(String[] args) throws Exception {

        // CREATE
        Employee e = new Employee();
        e.setId(127);
        e.setEname("Rahul");
        e.setDept("IT");
        e.setSalary(50000);
        e.setPhoneNO(987654321);

        EmployeeDAO.insertEmployee(e);
        System.out.println("Employee inserted successfully");

        // READ
        Employee emp = EmployeeDAO.viewEmployeesWithId(17);

        if(emp != null) {
            System.out.println("Employee Found:");
            System.out.println(emp.getId() + " " + emp.getEname());
        }
        else {
            System.out.println("Employee not found");
        }

        // UPDATE
        Employee updatedEmp = EmployeeDAO.updateEmployee(17, 60000);
        System.out.println("Updated Salary: " + updatedEmp.getSalary());

        // DELETE
        Employee deletedEmp = EmployeeDAO.deleteEmployee(17);
        if(deletedEmp != null) System.out.println("Employee deleted: " + deletedEmp.getEname());

    }
}