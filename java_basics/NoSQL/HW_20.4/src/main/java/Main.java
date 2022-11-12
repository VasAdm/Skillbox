import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Controller controller = new Controller();
    private static final String info = """
            Для добавления магазина введите команду: 'ДОБАВИТЬ_МАГАЗИН {название магазина}'
            Для добавления товара введите команду: 'ДОБАВИТЬ_ТОВАР {название товара} {цена}'
            Для добавления товара в магазин введите команду: 'ВЫСТАВИТЬ_ТОВАР {название товара} {название магазина}'
            Для получения информации о товарах во всех магазинах введите команду: 'СТАТИСТИКА_ТОВАРОВ'
            Для завершения работы введите команду: 'ВЫХОД'
            """;

    public static void main(String[] args) {

        System.out.println(info);

        while (true) {
            String tmpString = scanner.nextLine();
            if (tmpString.equals("ВЫХОД")) break;
            if (tmpString.equals("СТАТИСТИКА_ТОВАРОВ")) {
                controller.goodsStat();
                continue;
            }
            String[] strArr = spliterator(tmpString).toArray(new String[0]);
            if (strArr[0].equals("ДОБАВИТЬ_МАГАЗИН") && strArr.length == 2) {
                controller.addShop(strArr[1]);
                continue;
            }

            if (strArr[0].equals("ДОБАВИТЬ_ТОВАР") && strArr.length == 3) {
                controller.addGood(strArr[1], strArr[2]);
                continue;
            }

            if (strArr[0].equals("ВЫСТАВИТЬ_ТОВАР") && strArr.length == 3) {
                controller.putGoodToShop(strArr[1], strArr[2]);
                continue;
            }

            System.out.println("Ошибка" + System.lineSeparator() + info);
        }
    }

    private static @NotNull List<String> spliterator(String subjectString) {
        List<String> matchList = new ArrayList<>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(subjectString);
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                // Add double-quoted string without the quotes
                matchList.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                // Add single-quoted string without the quotes
                matchList.add(regexMatcher.group(2));
            } else {
                // Add unquoted word
                matchList.add(regexMatcher.group());
            }
        }

        return matchList;
    }

}