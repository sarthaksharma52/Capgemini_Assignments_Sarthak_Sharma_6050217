package SpringAssignments.EmployeeSpringApp_17March.src.main.java.autoWiring.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autoWiring.repository.Employee;
import autoWiring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee getEmployeeById(int id) {
        return repo.getEmployeeById(id);
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return repo.getAllEmployees();
    }

    @Override
    public void createEmployee(Employee emp) {
        repo.addEmployee(emp);
    }

    @Override
    public void updateEmployee(Employee emp) {
        repo.updateEmployee(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteEmployee(id);
    }
}