package com.techelevator;

public class Employee {
    //Instance variables -->private members
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Accessors
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getDepartment(){
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public String getFullName() {
        return (lastName + ", " + firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //constructor

    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    //Method
    public void raiseSalary(double percent) {
        this.annualSalary = annualSalary + (annualSalary * (percent / 100));
    }
}











