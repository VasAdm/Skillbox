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
      StringBuilder number = new StringBuilder();
      String regex = "[0-9]+";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()) {
        int start = matcher.start();
        int end = matcher.end();
        number.append(input, start, end);
      }
      if (number.length() == 10) {
        number = new StringBuilder("7".concat(number.toString()));
      } else if (number.length() == 11 && number.charAt(0) == '8')  {
        number = new StringBuilder("7".concat(number.substring(1, number.length())));
      } else if (number.length() != 11 || number.charAt(0) != '7') number = new StringBuilder("Неверный формат номера");
      System.out.println(number);
    }
  }

}
