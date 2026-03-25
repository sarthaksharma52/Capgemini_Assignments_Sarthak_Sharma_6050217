package com.example.demo.dto;

public class EmployeeDeptDTO {

    private String employeeName;
    private String deptName;
    private String managerName;

    public EmployeeDeptDTO(String employeeName, String deptName, String managerName) {
        this.employeeName = employeeName;
        this.deptName = deptName;
        this.managerName = managerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getManagerName() {
        return managerName;
    }
}