import java.time.LocalDate;
import java.time.Period;

public class Main {

  public static void main(String[] args) {
    LocalDate birthday = LocalDate.of(1995, 5, 23);

    getPeriodFromBirthday(birthday);
  }
  private static String getPeriodFromBirthday(LocalDate birthday) {
    LocalDate today = LocalDate.now();
    Period period = Period.between(birthday, today);

    String result = period.getYears() + " years, " + period.getMonths() + " month, " + period.getDays() + " days";
    System.out.println(result);

    int x = 5;
    System.out.println(x++ - ++x);
    return result;
  }
}