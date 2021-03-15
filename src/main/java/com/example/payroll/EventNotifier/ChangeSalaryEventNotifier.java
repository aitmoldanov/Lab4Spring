package com.example.payroll.EventNotifier;


import com.example.payroll.Employee;
import org.springframework.context.ApplicationEvent;

public class ChangeSalaryEventNotifier extends ApplicationEvent {

    private Employee employee;

    public ChangeSalaryEventNotifier(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
