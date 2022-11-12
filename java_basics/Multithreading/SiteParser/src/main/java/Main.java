import java.io.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите адрес сайта: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Page root = new Page(reader.readLine());
        System.out.print("\nВведите путь к файлу сохранения: ");
        String path = reader.readLine();

        new ForkJoinPool().invoke(new Parser(root));


        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(root.toString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
