import org.checkerframework.checker.units.qual.C;

import java.util.Scanner;

public class Main {
    public static final int CONTAINER = 27;
    public static final int CARGO = 12 * CONTAINER;

    public static void main(String[] args) {
//        System.out.println("Сколько всего ящиков?");
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int boxesInt = Integer.parseInt(boxes);
        int containers = 1;
        int cargos = 1;

        for (int i = 1; i <= boxesInt; i++) {
            if ((i % CARGO) == 1) {
                System.out.println("Грузовик: " + cargos++);
            }
            if ((i % CONTAINER) == 1) {
                System.out.println("\tКонтейнер: " + containers++);
            }
            System.out.println("\t\tЯщик: " + i);
        }
        System.out.println("Необходимо:" + System.lineSeparator() +
                "грузовиков - " + (int) Math.ceil((double) boxesInt / CARGO) + " шт." + System.lineSeparator() +
                "контейнеров - " + (int) Math.ceil((double) boxesInt / CONTAINER) + " шт.");
    }
}
