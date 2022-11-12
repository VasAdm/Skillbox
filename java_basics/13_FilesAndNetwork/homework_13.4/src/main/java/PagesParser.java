import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class PagesParser {
    private static final String parserAtr = "a.card__title";
    private static final String pagesAtr = "li.pagination__item a";
    private static final String pagination = "?page=";

    public static void parsePage(String source) {
        Elements elements = new Elements();
        AtomicInteger counter = new AtomicInteger();
        int amountOfPages = getAmountOfPages(source);

        for (int i = 1; i <= amountOfPages; i++) {
            elements.addAll(getElements(source + pagination + i, parserAtr));
        }
        elements.forEach(element -> {
            counter.getAndIncrement();
            System.out.println(counter + " " +
                    element.text() + " -> " +
                    element.absUrl("href"));
        });
    }

    private static int getAmountOfPages(String url) {

        String lastPage = Objects.requireNonNull(Objects.requireNonNull(getElements(url, pagesAtr)).last()).absUrl("href");
        return Integer.parseInt(lastPage.substring(lastPage.indexOf(pagination) + pagination.length()));
    }

    private static Elements getElements(String url, String atr) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(doc).select(atr);
    }
}
