package com.example.payroll;

import com.example.payroll.Dao.EmployeeDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDao;
    private static AnnotationConfigApplicationContext context;
    public static void main(String[] args){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.example.payroll");
        context.refresh();
        employeeDao = context.getBean("employeeDAO", EmployeeDAO.class);

        System.out.println(employeeDao.getEmployees());
        while(true){
            menu();
        }
    }

    private static void menu() {
        System.out.println("[1] Regular Salaried-commission\n" +
                "[2] Hourly employees\n" +
                "[3] Commission employees\n" +
                "[4] Salaried employees\n" +
                "[5] exit");
        int choice = scanner.nextInt();
        double percent;

        switch(choice){
            case 1:
                System.out.println("Type the percent of salaried-commission employees:");
                percent = scanner.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getEmployeeType() == EmployeeType.SALARIEDCOMMISSION){
                        employeeDao.salaryChange(employee, percent);
                    }
                }
                break;
            case 2:
                System.out.println("Type the percent of hourly employees:");
                percent = scanner.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getEmployeeType() == EmployeeType.HOURLY){
                        employeeDao.salaryChange(employee, percent);
                    }
                }
                break;
            case 3:
                System.out.println("Type the percent of salary for commission employees:");
                percent = scanner.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getEmployeeType() == EmployeeType.COMMISSION){
                        employeeDao.salaryChange(employee, percent);
                    }
                }
                break;
            case 4:
                System.out.println("Type the percent of salary for salaried employees:");
                percent = scanner.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getEmployeeType() == EmployeeType.REGULAR){
                        employeeDao.salaryChange(employee, percent);
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
