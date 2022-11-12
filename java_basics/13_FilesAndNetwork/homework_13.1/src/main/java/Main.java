import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите путь до папки: ");
            String path = scanner.nextLine();
            System.out.printf("Размер папки %s %s%n", path, readableFileSize(FileUtils.calculateFolderSize(path)));
        }
    }

    public static String readableFileSize(long size) {
        if (size <= 1) {
            return size + " byte";
        }

        final String[] units = new String[] { "bytes", "KB", "MB", "GB", "TB", "PB", "EB" };
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.##").format(size / Math.pow(1024, digitGroups))
                + " " + units[digitGroups];
    }
}
