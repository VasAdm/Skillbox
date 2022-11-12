import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E").localizedBy(new Locale("us"));

        String outputToString = "";

        for (int i = 0; birthday.isBefore(today) || birthday.isEqual(today); i++) {
            String str = (i + " - " + formatter.format(birthday)) + System.lineSeparator();
            outputToString = outputToString.concat(str);
            birthday = birthday.plusYears(1);
        }

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        return outputToString;
    }
}
