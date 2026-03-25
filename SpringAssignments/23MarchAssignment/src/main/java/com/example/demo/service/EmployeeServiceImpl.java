package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.*;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Department;
import com.example.demo.exception.*;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private DepartmentRepository deptRepo;

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee add(Employee e) {

        // Fetch department from DB
        Department dept = deptRepo.findById(e.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Set managed department
        e.setDepartment(dept);

        // Save employee
        return repo.save(e);
    }

    public List<EmployeeDeptDTO> getAll() {
        return repo.getEmployeeDeptDetails();
    }

    public List<DepartmentCountDTO> count() {
        return repo.countEmployees();
    }

    public List<Employee> getByDept(String name) {
        List<Employee> list = repo.findByDepartment_Name(name);

        if (list.isEmpty())
            throw new DepartmentNameNotFoundException("Department not found: " + name);

        return list;
    }

    public EmployeeDeptDetailsDTO getByMobile(String mobile) {

        Employee e = repo.findByMobile(mobile)
                .orElseThrow(() ->
                        new MobileNumberDoesNotExistsForEmployeeException("Mobile not found: " + mobile));

        return new EmployeeDeptDetailsDTO(
                e.getId(),
                e.getName(),
                e.getDepartment().getName(),
                e.getDepartment().getManagerName()
        );
    }
}