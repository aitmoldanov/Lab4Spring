package com.example.payroll;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    void updateById(Employee employee);
}
