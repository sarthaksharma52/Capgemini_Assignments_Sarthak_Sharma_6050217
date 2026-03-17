package cg.demo.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeDemoEm {
	@Id	
    private int eidDemo;
    private String enameDemo;

    @Embedded
    private AddressDemoEm address;

    public EmployeeDemoEm() {}

    public EmployeeDemoEm(int eidDemo, String enameDemo, AddressDemoEm address) {
        this.eidDemo = eidDemo;
        this.enameDemo = enameDemo;
        this.address = address;
    }

    public int getEidDemo() {
        return eidDemo;
    }

    public void setEidDemo(int eidDemo) {
        this.eidDemo = eidDemo;
    }

    public String getEnameDemo() {
        return enameDemo;
    }

    public void setEnameDemo(String enameDemo) {
        this.enameDemo = enameDemo;
    }

    public AddressDemoEm getAddress() {
        return address;
    }

    public void setAddress(AddressDemoEm address) {
        this.address = address;
    }

}