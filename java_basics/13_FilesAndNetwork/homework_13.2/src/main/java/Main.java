import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Какую директорию нужно скопировать? ");
            String src = scanner.nextLine();
            System.out.println("Куда поместить скопированную директорию? ");
            String dst = scanner.nextLine();
            FileUtils.copyFolder(src, dst);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
