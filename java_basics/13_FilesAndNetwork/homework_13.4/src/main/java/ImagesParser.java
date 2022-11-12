import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ImagesParser {
    public static void parseImages(String source, String destination) {
        Elements elements = getElements(source);
        elements.forEach(element -> {
            try {
                URL url = new URL(element.absUrl("src"));
                String fileName = getFileName(url.toString());
                File file = new File(destination + fileName);
                FileUtils.copyURLToFile(url, file);
                System.out.println(fileName);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        System.out.println("Download completed.");
    }

    private static String getFileName(String path) {
        String[] splitPath = path.split("/");
        return splitPath[splitPath.length - 1];
    }

    private static Elements getElements(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(doc).select("img.g-picture");
    }
}
