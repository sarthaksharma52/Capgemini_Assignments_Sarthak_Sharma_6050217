package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Employee name is required")
    private String name;

    @Min(value = 1000, message = "Salary must be greater than 1000")
    private double salary;

    @ElementCollection
    @NotEmpty(message = "Mobile numbers required")
    private Set<String> mobileNumbers;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @JsonBackReference
    private Department department;

    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}