import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmailList first = new EmailList();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                String[] inputList = input.split(" ");
                if (inputList.length > 2) {
                    System.out.println("Ошибка ввода данных!");
                } else {
                    switch (inputList[0]) {

                        case "LIST":
                            for (String email : first.getSortedEmails()) System.out.println(email);
                            break;

                        case "ADD":
                            first.add(inputList[1]);
                            break;

                        default:
                            System.out.println("Неизвестная команда.");
                    }
                }
            }
        }
    }
}