package com.example.payroll;

public class Employee {
    private int id;
    private String userName;
    private EmployeeType employeeType;
    private double salary;

    public Employee(int id, String userName, EmployeeType type, double salary) {
        this.id = id;
        this.userName = userName;
        this.employeeType = type;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", type=" + employeeType +
                ", salary=" + salary +
                '}';
    }
}
