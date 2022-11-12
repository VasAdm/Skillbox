import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {
    public static long calculateFolderSize(String path) {
        Path temp = Paths.get(path);
        long size = 0;
        try (Stream<Path> walk = Files.walk(temp)) {
            size =  walk.filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException ex) {
                            System.out.printf("Невозможно получить размер файла %s%n%s", p, ex);
                            return 0L;
                    }})
                        .sum();
        } catch (IOException ex) {
            System.out.printf("Ошибка при подсчёте размера директории %s%n", ex);
        }
        return size;
    }
}
