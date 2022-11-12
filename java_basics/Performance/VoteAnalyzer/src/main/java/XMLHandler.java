import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler implements Runnable {
    private Voter voter;
    private final File file;

    private static final HashMap<Voter, Integer> voterCounts = new HashMap<>();
    private static final HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();

    @Override
    public void run() {
        try {
            long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, this);
//            print();
            System.out.println("XMLHandler потребляет: " + (Runtime.getRuntime().freeMemory() - usage) + " bytes");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

//    public static void parseFile(String fileName) throws Exception {
//        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        XMLHandler handler = new XMLHandler();
//        parser.parse(new File(fileName), handler);
////        print();
//        System.out.println("XMLHandler потребляет: " + (Runtime.getRuntime().freeMemory() - usage) + " bytes");
//    }


    public XMLHandler(File file)
    {
        this.file = file;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        try {
            if (qName.equals("voter") && voter == null) {
                Date birthDay = CommonMethod.birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {
                int count = voterCounts.getOrDefault(voter, 0);
                voterCounts.put(voter, count + 1);

                int station = Integer.parseInt(attributes.getValue("station"));
                Date time = CommonMethod.visitDateFormat.parse(attributes.getValue("time"));
                WorkTime workTime = voteStationWorkTimes.get(station);

                if (workTime == null) {
                    workTime = new WorkTime();
                    voteStationWorkTimes.put(station, workTime);
                }
                workTime.addVisitTime(time.getTime());
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter")) voter = null;
    }


    private static void print() {
        //Printing results
        CommonMethod.print(voteStationWorkTimes, voterCounts);

    }
}
