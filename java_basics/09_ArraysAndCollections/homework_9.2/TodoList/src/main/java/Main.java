import java.util.Scanner;

public class Main {
    private static final TodoList todoList = new TodoList();
    private static int index = 0;
    private static boolean status = true;

    public static void main(String[] args) {

        while (status) {
            String todo = "";
            System.out.println("Введите команду, для справки используйте \"HELP\".");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            String[] arrCommand = command.split(" ");

            if (arrCommand[0].equals("EDIT") || arrCommand[0].equals("DELETE")) {
                index = Integer.parseInt(arrCommand[1]);
                if (arrCommand[0].equals("EDIT")) {
                    for (int i = 2; i < arrCommand.length; i++) {
                        todo = todo.concat(arrCommand[i] + " ");
                    }
                }
            } else {
                for (int i = 1; i < arrCommand.length; i++) {
                    todo = todo.concat(arrCommand[i] + " ");
                }
            }
            todo = todo.trim();

            switch (arrCommand[0]) {
                case "HELP":
                    System.out.println("Список доступных команд: " + System.lineSeparator() +
                            "\tLIST - список дел" + System.lineSeparator() +
                            "\tADD - добавить задачу" + System.lineSeparator() +
                            "\tEDIT - редактировать задачу" + System.lineSeparator() +
                            "\tDELETE - удалить задачу" + System.lineSeparator() +
                            "\tEXIT - завершить выполнение программы");
                    break;
                case "LIST":
                    todoList.getTodos();
                    break;
                case "ADD":
                    todoList.add(todo);
                    break;
                case "EDIT":
                    todoList.edit(todo, index);
                    break;
                case "DELETE":
                    todoList.delete(index);
                    break;
                case "EXIT":
                    status = false;
                    break;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }
}