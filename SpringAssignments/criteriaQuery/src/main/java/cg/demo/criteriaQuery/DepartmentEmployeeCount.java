package cg.demo.criteriaQuery;

public class DepartmentEmployeeCount {
    String deptName;
    Long count;

    public DepartmentEmployeeCount() {
    }

    public DepartmentEmployeeCount(String deptName, long count) {
        this.deptName = deptName;
        this.count = count;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DepartmentEmployeeCount [deptName=" + deptName + ", count=" + count + "]";
    }

}