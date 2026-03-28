package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Loan;
import com.example.demo.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return service.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return service.getLoanById(id);
    }
    
    @PutMapping("/{id}/status")
    public Loan updateLoanStatus(@PathVariable Long id, @RequestBody java.util.Map<String, String> request) {
        return service.updateLoanStatus(id, request.get("status"));
    }
    
//    @PutMapping("/{id}/status")
//    public Loan updateLoanStatus(@PathVariable Long id, @RequestParam String status) {
//        return service.updateLoanStatus(id, status);
//    }
}