import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class Loader
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("res/data-18M.xml");

        double time = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLParserSAX handler = new XMLParserSAX();
        parser.parse(file, handler);

        time = ((System.currentTimeMillis() - time) / 1000.0);

        System.out.println(time);
    }
}
