package com.example.payroll;


import com.example.payroll.Employee;

public class SalaryEstimateService {
    public Employee estimate(Employee employee, double percent){
        employee.setSalary(employee.getSalary()*((100+percent)/100));
        return employee;
    }
}
