package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> add(@Valid @RequestBody Employee e) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(e));
    }

    @GetMapping
    public List<EmployeeDeptDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/count")
    public List<DepartmentCountDTO> count() {
        return service.count();
    }

    @GetMapping("/dept")
    public List<Employee> byDept(@RequestParam String name) {
        return service.getByDept(name);
    }

    @GetMapping("/mobile")
    public EmployeeDeptDetailsDTO byMobile(@RequestParam String mobile) {
        return service.getByMobile(mobile);
    }
}