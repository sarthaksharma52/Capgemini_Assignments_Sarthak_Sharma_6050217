package beans;

import java.util.List;

public class SBU {

    private int sbuCode;
    private String sbuName;
    private String sbuHead;
    private List<Employee> empList;

    public int getSbuCode() {
        return sbuCode;
    }

    public void setSbuCode(int sbuCode) {
        this.sbuCode = sbuCode;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void display() {

        System.out.println("SBU Details");
        System.out.println("SBU Code: " + sbuCode);
        System.out.println("SBU Name: " + sbuName);
        System.out.println("SBU Head: " + sbuHead);

        System.out.println("\nEmployee Details:");

        for (Employee e : empList) {
            System.out.println(e);
        }
    }
}