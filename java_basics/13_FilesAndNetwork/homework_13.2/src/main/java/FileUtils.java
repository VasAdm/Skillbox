import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        Files.walk(Paths.get(sourceDirectory))
                .forEach(source -> {
                    Path destination = Paths.get(destinationDirectory, source.toString().substring(sourceDirectory.length()));
                    try {
                        Files.copy(source, destination,
                                REPLACE_EXISTING,
                                COPY_ATTRIBUTES,
                                NOFOLLOW_LINKS);
                    } catch (DirectoryNotEmptyException ex) {
                        System.out.println("Дирректория " + ex.getMessage() + " уже существует!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
//
                    }
                });
    }
}