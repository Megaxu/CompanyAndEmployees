package Employees;

import Company.Company;

public class Operator implements Employee {

  private double operatorSalary;

  public Operator(double salary) {
    this.operatorSalary = salary;
  }

  @Override
  public double getMonthSalary(Company company) {
    return operatorSalary;
  }
}