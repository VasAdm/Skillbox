import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Page implements Comparable<Page> {
    private final String url;
    private final Set<Page> children = new TreeSet<>();
    int level = 0;

    public Page(String url) {
        this.url = url;
    }

    public Set<Page> getChildren() {
        return children;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public int getLevel() {
        return level;
    }

    private static Document pagesParser(String url) throws IOException {
        try {
            int delay = (int) (Math.random() * ((5000 - 3000) + 1)) + 3000;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Jsoup
                .connect(url)
                .maxBodySize(0)
                .get();
    }

    public void linkCollector() {
        try {
            Elements elements = Objects.requireNonNull(pagesParser(this.getUrl())).select("a");
            elements.forEach(element -> {
                String str = element.attr("abs:href");
                String currentString = this.getUrl();


                boolean containParent = str.matches(currentString + "[^.#]+");

                if (containParent && !Supporter.getLinks().contains(str)) {
                    Supporter.addLink(str);
                    children.add(new Page(str));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getUrl());
        getChildren().forEach(child -> {

            child.setLevel(this.getLevel() + 1);

            stringBuilder.append("\n");
            stringBuilder.append("\t".repeat(Math.max(0, level + 1)));
            stringBuilder.append(child);
        });

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Page o) {
        return this.getUrl().compareTo(o.getUrl());
    }
}
