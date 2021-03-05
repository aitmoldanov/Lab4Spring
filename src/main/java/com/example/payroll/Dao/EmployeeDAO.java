package com.example.payroll.Dao;
import com.example.payroll.Employee;
import com.example.payroll.EmployeeType;
import com.example.payroll.Event.ChangeSalaryEvent;
import com.example.payroll.Service.SalaryEstimateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@PropertySource("application.properties")
@Component
public class EmployeeDAO implements ApplicationEventPublisherAware {
    @Value("${employeeDao.dbUrl}")
    private String dbUrl;
    @Value("${employeeDao.username}")
    private String dbUsername;
    @Value("${employeeDao.password}")
    private String dbPassword;
    private ApplicationEventPublisher applicationEventPublisher;
    private final SalaryEstimateService salaryEstimateService = new SalaryEstimateService();
    Connection connection;
    Statement statement;
    private List<Employee> employees = new ArrayList<>();
    public void salaryChange(Employee employee, double percentage) {
        System.out.println("EmployeeDao.ApplicationEventPublisherAware");
        System.out.println("SALARY OF EMPLOYEE CHANGED");
        System.out.println("employee = " + employee.getUserName() + "; type: "+ employee.getEmployeeType());
        employee = salaryEstimateService.calculate(employee, percentage);
        updateEmployees(employee);
        this.applicationEventPublisher.publishEvent(new ChangeSalaryEvent(this, employee));
    }
    public void updateEmployees(Employee employee) {
        try {
            String query = "UPDATE employee SET salary = '" + employee.getSalary() +"'  WHERE id = " + employee.getId();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    @PostConstruct
    public void init() throws SQLException {
        this.createDbConnection();
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void createDbConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();
            String queryString = "select * from employee";
            ResultSet resultSet = statement.executeQuery(queryString);
            while (resultSet.next()){
                EmployeeType employeeType =  EmployeeType.valueOf(resultSet.getString(3));
                Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), employeeType, resultSet.getInt(4));
                employees.add(employee);
            }
            System.out.println("UserService.createDbConnection");
            System.out.println(employees);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    @PreDestroy
    public void destroyCustom() throws SQLException {
        this.closeConnections();
    }

    public void closeConnections() throws SQLException {
        connection.close();
        System.out.println("UserService.closeConnections");
    }
}
