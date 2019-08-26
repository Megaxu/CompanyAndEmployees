import Company.Company;
import Employees.Employee;
import Employees.Manager;
import Employees.Operator;
import Employees.TopManager;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    Company company = new Company(1000000);
    System.out.println("Доход компании составляет: " + company.getIncome());

    company.hireEmloyees(new ArrayList<>(formListOfCandidates()));
    company.checkEmployeesList();
    company.dismissEmployee(2);
    company.checkEmployeesList();

    company.getLowestSalaryStaff(3);
    company.getTopSalaryStaff(3);

    company.setIncome(10000010);
    System.out.println("Доход компании стал составлять: " + company.getIncome());

    company.getLowestSalaryStaff(3);
    company.getTopSalaryStaff(3);
  }

  private static ArrayList<Employee> formListOfCandidates() {
    ArrayList<Employee> listOfCandidates = new ArrayList<>();
    for (int i = 1; i < 91; i++) { // от 1 для того, чтобы не было нулевой зарплаты
      listOfCandidates.add(new Operator(400 * i));
      listOfCandidates.add(new Manager(650 * i));
      listOfCandidates.add(new TopManager(1000 * i));
    }
    return listOfCandidates;
  }
}