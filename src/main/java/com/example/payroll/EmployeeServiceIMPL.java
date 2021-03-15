package com.example.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void updateById(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()){
            employeeRepository.save(employee);
        }
    }
}
