package SpringAssignments.EmployeeSpringApp_17March.src.main.java.autoWiring.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import autoWiring.repository.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Map<Integer, Employee> employeeDB = new HashMap<>();

    public EmployeeRepositoryImpl() {

        employeeDB.put(100, new Employee(100, "Rama", 12345.67));
        employeeDB.put(101, new Employee(101, "Krishna", 20000));
        employeeDB.put(102, new Employee(102, "Arjun", 30000));
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDB.get(id);
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return employeeDB;
    }

    @Override
    public void addEmployee(Employee emp) {
        employeeDB.put(emp.getId(), emp);
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeDB.put(emp.getId(), emp);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDB.remove(id);
    }
}