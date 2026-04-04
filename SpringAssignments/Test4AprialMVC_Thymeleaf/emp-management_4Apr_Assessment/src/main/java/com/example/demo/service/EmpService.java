package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.Emp;

public interface EmpService {

    List<Emp> getAll();
    Emp getById(Integer id);
    void save(Emp emp);
    void delete(Integer id);
}