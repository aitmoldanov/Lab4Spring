package com.example.payroll.EventNotifier;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChangeSalaryEventHandler implements ApplicationListener<ChangeSalaryEventNotifier> {

    @Override
    public void onApplicationEvent(ChangeSalaryEventNotifier changeSalaryEventNotifier) {
        System.out.println("ChangeSalaryEventHandler.onApplicationEvent");
        System.out.println("Changed salary: " + changeSalaryEventNotifier.getEmployee());
    }
}
