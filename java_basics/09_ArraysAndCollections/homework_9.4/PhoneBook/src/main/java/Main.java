import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook test = new PhoneBook();
        while (true) {
            System.out.println("Введите номер, имя или команду: ");
            String input = scanner.nextLine();

            PhoneBook.PhoneOrNum num = (PhoneBook.PhoneOrNum) test.checkInput(input);

            switch (num) {
                case LIST:
                    Set<String> output = test.getAllContacts();
                    for (String s : output) System.out.println(s);
                    break;

                case PHONE:
                    if (test.getNameByPhone(input).isBlank()) {
                        System.out.println("Такого номера нет в телефонной книге." + System.lineSeparator() +
                                "Введите имя абонента для номера \"" + input + "\": ");
                        String inputSecond = scanner.nextLine();
                        test.addContact(input, inputSecond);
                        System.out.println("Контакт сохранен!");
                    } else System.out.println(test.getNameByPhone(input));
                    break;

                case NAME:
                    if (test.getPhonesByName(input).size() == 0) {
                        System.out.println("Такого имени в телефонной книге нет." + System.lineSeparator() +
                                "Введите номер телефона для абонента \"" + input + "\": ");
                        String inputSecond = scanner.nextLine();
                        test.addContact(inputSecond, input);
                        System.out.println("Контакт сохранен!");
                    } else {
                        for (String line: test.getPhonesByName(input)) {
                            System.out.println(line);
                        }
                    }
                    break;
                case UNDEFINED:
                    System.out.println("Неверный формат ввода");
            }
        }
    }
}
