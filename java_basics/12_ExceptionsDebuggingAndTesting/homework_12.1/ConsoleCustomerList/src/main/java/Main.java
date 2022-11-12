import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров\n\texit";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        boolean isWorking = true;

        while (isWorking) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);

                switch (tokens[0]) {
                    case "add":
                        if (tokens.length == 1) {
                            throw new IllegalArgumentException("Command without data");
                        } else {
                            executor.addCustomer(tokens[1]);
                        }
                        break;
                    case "list":
                        executor.listCustomers();
                        break;
                    case "remove":
                        if (tokens.length == 1) {
                            throw new IllegalArgumentException("Command without data");
                        } else {
                            executor.removeCustomer(tokens[1]);
                        }
                        break;
                    case "count":
                        System.out.println("There are " + executor.getCount() + " customers");
                        break;
                    case "help":
                        System.out.println(helpText);
                        break;
                    case "exit":
                        System.out.println("Good bye!");
                        isWorking = false;
                        break;
                    default:
                        System.out.println(COMMAND_ERROR);
                        break;
                }
            } catch (AuxiliaryException ex) {
                System.out.println("Вы ввели: " + ex.getName()
                        + System.lineSeparator()
                        + ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

