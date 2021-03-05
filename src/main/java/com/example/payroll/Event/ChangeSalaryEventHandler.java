package com.example.payroll.Event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChangeSalaryEventHandler implements ApplicationListener<ChangeSalaryEvent> {

    @Override
    public void onApplicationEvent(ChangeSalaryEvent changeSalaryEvent) {
        System.out.println("ChangeSalaryEventHandler.onApplicationEvent");
        System.out.println("Changed salary: " + changeSalaryEvent.getEmployee());
    }
}
