package Employees;

import Company.Company;

public class Manager implements Employee {

  private final static double PERCENT = 0.05;
  private double fixedPart;

  public Manager(double fixedPart) {
    this.fixedPart = fixedPart;
  }

  @Override
  public double getMonthSalary(Company company) {
    return fixedPart + company.getIncome() * PERCENT;
  }
}