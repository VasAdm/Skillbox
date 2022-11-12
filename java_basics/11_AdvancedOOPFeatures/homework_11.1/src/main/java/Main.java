import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        System.out.println("================");
        sortBySalaryAndAlphabet(staff);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));

//    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
//        Collections.sort(staff, (o1, o2) -> {
//            int digit = o1.getSalary().compareTo(o2.getSalary());
//            if (digit == 0) {return o1.getName().compareTo(o2.getName());}
//            return digit;
//        });
    }
}