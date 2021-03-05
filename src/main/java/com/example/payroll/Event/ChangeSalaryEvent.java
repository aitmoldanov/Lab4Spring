package com.example.payroll.Event;


import com.example.payroll.Employee;
import org.springframework.context.ApplicationEvent;

public class ChangeSalaryEvent extends ApplicationEvent {

    private Employee employee;

    public ChangeSalaryEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
