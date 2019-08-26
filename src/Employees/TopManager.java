package Employees;

import Company.Company;

public class TopManager implements Employee {

  private double fixedPart;
  private final static double BONUS = 3000000;
  private final static double MIN_INCOME_FOR_BONUS = 10000000;

  public TopManager(double fixedPart) {
    this.fixedPart = fixedPart;
  }

  @Override
  public double getMonthSalary(Company company) {
    return company.getIncome() > MIN_INCOME_FOR_BONUS ? fixedPart + BONUS : fixedPart;
  }
}