public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    String charsetStr = "руб";
    int start = 0;
    int sum = 0;

    while (start != -1) {
      int end = text.indexOf(charsetStr, start);
      start = text.lastIndexOf(" ", end - 2);
      sum += Integer.parseInt(text.substring(start, end).trim());
      start = text.indexOf(" ", end);
    }

    System.out.println(sum);
  }
}