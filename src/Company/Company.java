package Company;

import Employees.Employee;
import java.util.ArrayList;
import java.util.Comparator;

public class Company {

  private double incomeCompany;
  private ArrayList<Employee> employeeArrayList = new ArrayList<>();

  public Company(double incomeCompany) {
    this.incomeCompany = incomeCompany;
  }

  public void setIncome(double incomeCompany) {
    this.incomeCompany = incomeCompany;
  }

  public double getIncome() {
    return incomeCompany;
  }

  public void hireEmloyees(ArrayList<Employee> listOfHired) {
    employeeArrayList.addAll(listOfHired);
  }

  public void checkEmployeesList() {
    for (Employee employee : employeeArrayList) {
      System.out.println(
          "Сотрудник " + employee + " с зарплатой " + employee
              .getMonthSalary(this));
    }
    System.out.println("Всего сотрудников в компании: " + employeeArrayList.size());
  }

  public void dismissEmployee(int number) {
    Employee dismissEmployee = employeeArrayList.get(number);
    employeeArrayList.remove(number);
    System.out.println("Сотрудник " + dismissEmployee + " уволен");
  }

  public void getTopSalaryStaff(int count) {
    ArrayList<Employee> bestSalary = new ArrayList<>(employeeArrayList);
    bestSalary.sort(new ComparatorEmployee(this));
    System.out.println("Список из " + count + " самых высоких зарплат в компании");
    printEmloyeeList(new ArrayList<>(bestSalary.subList(0, count)));
  }

  public void getLowestSalaryStaff(int count) {
    ArrayList<Employee> worstSalary = new ArrayList<>(employeeArrayList);
    worstSalary.sort(new ComparatorEmployee(this).reversed());

    System.out.println("Список из " + count + " самых низких зарплат в компании");
    printEmloyeeList(new ArrayList<>(worstSalary.subList(0, count)));
  }

  private void printEmloyeeList(ArrayList<Employee> list) {
    for (Employee employee : list) {
      System.out.println("Сотрудник " + employee + " с зарплатой " + employee.getMonthSalary(this));
    }
  }

  private static class ComparatorEmployee implements Comparator<Employee> {

    private Company company;

    private ComparatorEmployee(Company company) {
      this.company = company;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
      if (o1.getMonthSalary(company) > o2.getMonthSalary(company)) {
        return -1;
      } else if ((o1.getMonthSalary(company) < o2.getMonthSalary(company))) {
        return 1;
      }
      return 0;
    }
  }
}