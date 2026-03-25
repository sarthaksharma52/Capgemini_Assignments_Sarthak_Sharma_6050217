package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.*;
import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT new com.example.demo.dto.EmployeeDeptDTO(e.name,d.name,d.managerName) FROM Employee e JOIN e.department d")
    List<EmployeeDeptDTO> getEmployeeDeptDetails();

    @Query("SELECT new com.example.demo.dto.DepartmentCountDTO(d.name, COUNT(e)) FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
    List<DepartmentCountDTO> countEmployees();

    List<Employee> findByDepartment_Name(String name);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department WHERE :mobile MEMBER OF e.mobileNumbers")
    Optional<Employee> findByMobile(@Param("mobile") String mobile);
}