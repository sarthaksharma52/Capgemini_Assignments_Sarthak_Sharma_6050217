package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("emps", service.getAll());
        return "viewall";
    }

    @GetMapping("/edit/{eid}")
    public String edit(@PathVariable Integer eid, Model model) {

        Emp emp = service.getById(eid);

        EmpDto dto = new EmpDto();
        dto.setEmpId(emp.getEmpId());
        dto.setEmpName(emp.getEmpName());
        dto.setEmpSal(emp.getEmpSal());
        dto.setEmpDoj(emp.getEmpDoj());
        dto.setDeptName(emp.getDeptName());

        model.addAttribute("empDto", dto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("empDto") EmpDto dto,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            return "edit";
        }

        Emp emp = new Emp();
        emp.setEmpId(dto.getEmpId());
        emp.setEmpName(dto.getEmpName());
        emp.setEmpSal(dto.getEmpSal());
        emp.setEmpDoj(dto.getEmpDoj());
        emp.setDeptName(dto.getDeptName());

        service.save(emp);

        model.addAttribute("msg", "Employee Edited");
        model.addAttribute("emps", service.getAll());

        return "viewall";
    }

    @GetMapping("/delete/{eid}")
    public String delete(@PathVariable Integer eid, Model model) {

        service.delete(eid);

        model.addAttribute("msg", "Employee Deleted");
        model.addAttribute("emps", service.getAll());

        return "viewall";
    }
}