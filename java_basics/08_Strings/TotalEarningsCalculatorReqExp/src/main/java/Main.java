import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    int sum = 0;
    String regex = "[0-9]{1,9}[^,\\s]";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      sum += Integer.parseInt(text.substring(start,end));
    }
    return sum;
  }

}