package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.*;
import com.example.demo.entity.Employee;

public interface EmployeeService {

    Employee add(Employee e);

    List<EmployeeDeptDTO> getAll();

    List<DepartmentCountDTO> count();

    List<Employee> getByDept(String name);

    EmployeeDeptDetailsDTO getByMobile(String mobile);
}