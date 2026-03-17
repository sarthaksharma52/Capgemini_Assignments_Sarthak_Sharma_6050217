package cg.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.*;
import jakarta.persistence.OneToMany;

// 1 Dept -> M employees
@Entity
public class Department {
    @Id
    private int did;
    private String dname;
    private String hod;

    public Department() {
    }

    public Department(int did, String dname, String hod) {
        this.did = did;
        this.dname = dname;
        this.hod = hod;
    }

    @Override
    public String toString() {
        return "Department [did=" + did + ", dname=" + dname + ", hod=" + hod + "]";
    }

    // 1 Dept has M employees
    @OneToMany(mappedBy = "dept")
    // @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> emp;

    public List<Employee> getEmp() {
        return emp;
    }

    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getHod() {
        return hod;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }
}