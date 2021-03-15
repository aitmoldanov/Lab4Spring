package com.example.payroll;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AnnotationConfigApplicationContext context;
    private static EmployeeController controller;
    public static void main(String[] args){
        context = new AnnotationConfigApplicationContext();
        System.out.println(controller.getEmployees());
        while(true){
            menu();
        }
    }

    private static void menu() {
        System.out.println("1. Regular Salaried-commission\n" +
                "2. Hourly employees\n" +
                "3. Commission employees\n" +
                "4. Salaried employees\n" +
                "5. exit");
        int choice = scanner.nextInt();
        double percent;

        switch(choice){
            case 1:
                System.out.println("Type the percent of salaried-commission employees:");
                percent = scanner.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.SALARIEDCOMMISSION){
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 2:
                System.out.println("Type the percent of hourly employees:");
                percent = scanner.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.HOURLY){
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 3:
                System.out.println("Type the percent of salary for commission employees:");
                percent = scanner.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.COMMISSION){
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 4:
                System.out.println("Type the percent of salary for salaried employees:");
                percent = scanner.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.REGULAR){
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 5:
                context.close();
                System.exit(0);
                break;
        }
    }
}
