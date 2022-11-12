import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      int spaceCounter = 0;
      String forEncodeCheck = new String(input.getBytes(), StandardCharsets.US_ASCII);
      boolean encodeCheck =  (input.compareTo(forEncodeCheck) == 0);
      char separator = ' ';

      for (int i = 0; i < input.length(); i++) {
        char symbol = input.charAt(i);
        if (symbol == separator) spaceCounter ++;
      }

      if (spaceCounter != 2 || encodeCheck) {
        System.out.println("Введенная строка не является ФИО");
      } else {
        String lastName = input.substring(0, input.indexOf( separator));
        String firstName = input.substring(input.indexOf(separator), input.lastIndexOf(separator)).trim();
        String middleName = input.substring(input.lastIndexOf(separator)).trim();

        System.out.println("Фамилия: " + lastName + System.lineSeparator() +
                           "Имя: " + firstName + System.lineSeparator() +
                           "Отчество: " + middleName);
      }
    }
  }


}