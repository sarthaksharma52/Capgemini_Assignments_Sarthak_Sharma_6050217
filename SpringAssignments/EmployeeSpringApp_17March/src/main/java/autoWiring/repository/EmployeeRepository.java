package SpringAssignments.EmployeeSpringApp_17March.src.main.java.autoWiring.repository;

import java.util.Map;

public interface EmployeeRepository {

    Employee getEmployeeById(int id);

    Map<Integer, Employee> getAllEmployees();

    void addEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void deleteEmployee(int id);
}