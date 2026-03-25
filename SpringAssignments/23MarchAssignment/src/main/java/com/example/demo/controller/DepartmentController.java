package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @PostMapping
    public Department add(@Valid @RequestBody Department d) {
        return repo.save(d);
    }
}