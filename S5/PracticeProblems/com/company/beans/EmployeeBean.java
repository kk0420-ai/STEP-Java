package com.company.beans;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private boolean isActive;

    public EmployeeBean() {}

    public EmployeeBean(String employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public boolean isActive() { return isActive; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        EmployeeBean emp = new EmployeeBean("E001", "John", "Doe", 50000);
        System.out.println(emp.getFullName());
    }
}
