package cg.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int emid;
    private String emname;
    private int emsalary;

    public Employee() {
    }

    // M Employee -> 1 Department
    @ManyToOne
    private Department dept;

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    // // 1 Employee -> 1 Department
    // @OneToOne(cascade = CascadeType.ALL)
    // private Department dept;

    public Employee(String emname, int emsalary) {
        this.emname = emname;
        this.emsalary = emsalary;
    }

    @Override
    public String toString() {
        return "Employee [emid=" + emid + ", emname="
                + emname + ", emsalary=" + emsalary + "]";
    }

    public int getemid() {
        return emid;
    }

    public void setemid(int emid) {
        this.emid = emid;
    }

    public String getemname() {
        return emname;
    }

    public void setemname(String emname) {
        this.emname = emname;
    }

    public int getemsalary() {
        return emsalary;
    }

    public void setemsalary(int emsalary) {
        this.emsalary = emsalary;
    }

}