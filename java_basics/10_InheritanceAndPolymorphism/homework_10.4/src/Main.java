import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company= new Company();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(30000));
        }

        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            workers.add(new Manager(40000));
            if (i % 8 == 0) {
                workers.add(new TopManager(50000, company));
            }
        }

        company.hireAll(workers);

        printEmployees(company);

        List<Employee> employees = company.getEmployees();
        for (int i = 0; i < employees.size()/2; i++) {
            company.fire(employees.get(i));
        }

        System.out.println("<==============>");
        printEmployees(company);
    }

    private static void printEmployees(Company company) {
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        for (Employee t: topSalaryStaff) {
            System.out.println(t.getMonthSalary() + " руб.");
        }

        System.out.println("<--------------->");
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
        for (Employee t: lowestSalaryStaff) {
            System.out.println(t.getMonthSalary() + " руб.");
        }
    }
}
