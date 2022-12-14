import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Employee {

  private String name;
  private Integer salary;
  private LocalDate workStart;

  public Employee(String name, Integer salary, LocalDate workStart) {
    this.name = name;
    this.salary = salary;
    this.workStart = workStart;
  }

  public static List<Employee> loadStaffFromFile(String path) {
    List<Employee> staff = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get(path));
      for (String line : lines) {
        String[] fragments = line.split("\t");
        if (fragments.length != 3) {
          System.out.println("Wrong line: " + line);
          continue;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        staff.add(new Employee(
            fragments[0],
            Integer.parseInt(fragments[1]),
            (LocalDate.parse(fragments[2], formatter)
        )));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return staff;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public LocalDate getWorkStart() {
    return workStart;
  }

  public void setWorkStart(LocalDate workStart) {
    this.workStart = workStart;
  }

  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    return name + " - " + salary + " - " + workStart.format(formatter);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name) &&
        Objects.equals(salary, employee.salary) &&
        Objects.equals(workStart, employee.workStart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, salary, workStart);
  }

}
