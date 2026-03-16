package beans;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
//    private String businessUnit;
    private SBU businessUnit;
    private int age;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

//    public void setBusinessUnit(String businessUnit) {
//        this.businessUnit = businessUnit;
//    }
    
    public void setBusinessUnit(SBU businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("Employee details");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Employee Salary : " + salary);
//        System.out.println("Employee BU : " + businessUnit);
        System.out.println("Employee Age : " + age);
        System.out.println(businessUnit.getSBUDetails());
    }
}