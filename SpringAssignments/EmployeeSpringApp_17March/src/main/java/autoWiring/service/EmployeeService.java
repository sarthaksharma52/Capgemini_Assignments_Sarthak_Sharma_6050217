package SpringAssignments.EmployeeSpringApp_17March.src.main.java.autoWiring.service;


import java.util.Map;

import autoWiring.repository.Employee;

public interface EmployeeService {

    Employee getEmployeeById(int id);

    Map<Integer, Employee> getAllEmployees();

    void createEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void deleteEmployee(int id);
}