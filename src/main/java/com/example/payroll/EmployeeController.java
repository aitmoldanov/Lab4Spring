package com.example.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    public void updateEmployee(Employee employee){
        employeeService.updateById(employee);
    }
}
