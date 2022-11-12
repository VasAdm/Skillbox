import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("res/data-0.2M.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLParserSAX handler = new XMLParserSAX();
        parser.parse(file, handler);

//        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
//        LocalDate date = new java.sql.Date(format.parse("1932.11.08").getTime()).toLocalDate();

//        System.out.println(date);
    }
}
