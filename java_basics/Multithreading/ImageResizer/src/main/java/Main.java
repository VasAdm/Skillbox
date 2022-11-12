import org.imgscalr.AsyncScalr;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\groom\\Pictures\\Wallpaper";
        String dstFolder = "C:\\Users\\groom\\Pictures\\Wallpaper_NEW";

        int core = Runtime.getRuntime().availableProcessors();
        System.out.printf("number of cores - %d\n", core);

        File srcDir = new File(srcFolder);

        List<File> files = new ArrayList<>(List.of(Objects.requireNonNull(srcDir.listFiles())));

        long start = System.currentTimeMillis();

        int newListSize;
        while (files.size() > 0) {
            newListSize = Math.min(core, files.size());
            List<File> partOfFiles = new ArrayList<>(files.subList(0, newListSize));
            files.removeAll(partOfFiles);
            ImageResizer resizer = new ImageResizer(partOfFiles, newWidth, dstFolder, start);
            new Thread(resizer).start();
        }
    }
}
