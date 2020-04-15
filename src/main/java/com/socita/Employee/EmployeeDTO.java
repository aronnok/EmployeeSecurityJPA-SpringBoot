package com.socita.Employee;

import com.socita.Employee.entities.Salary;
import lombok.ToString;

import java.util.List;

@ToString
public class EmployeeDTO {

    private Long employeeNumber;
    private String firstName;
    private String lastName;
    private String currentDepartmentNumber;
    private List<Salary> salaryHistory;

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getCurrentDepartmentNumber() {
        return currentDepartmentNumber;
    }

    public void setCurrentDepartmentNumber(String currentDepartmentNumber) {
        this.currentDepartmentNumber = currentDepartmentNumber;
    }

    public List<Salary> getSalaryHistory() {
        return salaryHistory;
    }

    public void setSalaryHistory(List<Salary> salaryHistory) {
        this.salaryHistory = salaryHistory;
    }
}
