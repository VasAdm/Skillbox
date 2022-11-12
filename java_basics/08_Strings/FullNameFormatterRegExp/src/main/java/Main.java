import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String regex = "[А-Яа-я-]+";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      if (matcher.results().count() == 3) {
        matcher.reset();
        String[] fio = new String[3];
        int i = 0;

        while (matcher.find()) {
          int start = matcher.start();
          int end = matcher.end();
          fio[i] = input.substring(start, end);
          i++;
        }
        System.out.println("Фамилия: " + fio[0] + System.lineSeparator() +
                "Имя: " + fio[1] + System.lineSeparator() +
                "Отчество: " + fio[2]);
      } else System.out.println("Введенная строка не является ФИО");
    }
  }
}