import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextIntoWords(String text) {
    StringBuilder sum = new StringBuilder();
    String regex = "[A-Za-z’]+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      sum.append(text, start, end).append(System.lineSeparator());
    }
    return sum.toString().trim();
  }
}