package cg.demo.criteriaQuery;

public class DepartmentEmployeeDetails {

    private String deptName;
    private String hod;
    private int empId;
    private String empName;

    public DepartmentEmployeeDetails(String deptName, String hod, int empId, String empName) {
        this.deptName = deptName;
        this.hod = hod;
        this.empId = empId;
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHod() {
        return hod;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "DepartmentEmployeeDetails [deptName=" + deptName +
                ", hod=" + hod +
                ", empId=" + empId +
                ", empName=" + empName + "]";
    }
}