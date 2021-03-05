package com.example.payroll.Service;


import com.example.payroll.Employee;

public class SalaryEstimateService {
    public Employee calculate(Employee employee, double percent){
        employee.setSalary(employee.getSalary()*((100+percent)/100));
        return employee;
    }
}
