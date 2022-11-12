import core.Line;
import core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MetroParser {
    private static Document mainPage;

    private static Elements linesNamesEl;
    private static ArrayList<Line> linesList;

    private static Elements stationsNamesEl;

    private static Elements connectionsSearcher;

    public MetroParser(String url) {
        try {
            mainPage = pagesParser(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Elements elements = Objects.requireNonNull(mainPage).select(Variables.attributeSelectMain);

        linesNamesEl = elements.select(Variables.attributeSelectNamesOfLines);
        stationsNamesEl = elements.select(Variables.attributeSelectLine);
        connectionsSearcher = elements.select(Variables.attributeSelectLinesLinks);

        createLines();
        createStations();
        linesConnections(url);
    }

    private static Document pagesParser(String url) throws IOException {
        return Jsoup
                .connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36")
                .cookie("auth", "token")
                .referrer("http://google.com")
                .data("query", "Java")
                .maxBodySize(0)
                .timeout(100000)
                .post();


//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:87.0) Gecko/20100101 Firefox/87.0")


    }

    public static void createLines() {
        linesList = new ArrayList<>();
        linesNamesEl.forEach(lnElement -> {
            String lineNumber = lnElement.attr(Variables.attributeLineNumber);
            String lineName = lnElement.text();
            linesList.add(new Line(lineNumber, lineName));
        });
    }

    private static void createStations() {
        linesList.forEach(line -> stationsNamesEl.forEach(stElement -> {
            if (stElement.attr(Variables.attributeLineNumber).equals(line.getNumber())) {
                Elements stationsNames = stElement.select(Variables.attributeLineName);
                stationsNames.forEach(station -> line.addStation(new Station(station.text(), line)));
            }
        }));
    }

    private static void linesConnections(String url) {
        linesList.forEach(link -> connectionsSearcher.forEach(stElement -> {
            if (stElement.attr(Variables.attributeLineLink).equals("lines-" + link.getNumber())) {
                String subLinkToLine = stElement.select("p > a").attr("href");
                String lineLink = url.substring(0, url.indexOf(".ru") + 3) + subLinkToLine;
                Document details = null;

                try {
                    details = Jsoup.connect(lineLink).maxBodySize(0).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements elements = Objects.requireNonNull(details).select("title");
                System.out.println(elements.text());

//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }));
    }

    public ArrayList<Line> getLinesList() {
        return linesList;
    }
}