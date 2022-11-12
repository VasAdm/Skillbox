import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

public class DOMParser implements Runnable {
    private static final HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static final HashMap<Voter, Integer> voterCounts = new HashMap<>();
    private final File file;

    public DOMParser(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            long start = System.currentTimeMillis();
            findEqualVoters(doc);
            System.out.println("Время работы программы составило: " + (System.currentTimeMillis() - start));

            fixWorkTimes(doc);
//            print();

            DBConnection.printVoterCounts();


            System.out.println("DOMParser потребляет: " + (Runtime.getRuntime().freeMemory() - usage) + " bytes");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

//    public static void parseFile(String fileName) throws Exception {
//        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(new File(fileName));
//
//        findEqualVoters(doc);
//        fixWorkTimes(doc);
////        print();
//        System.out.println("DOMParser потребляет: " + (Runtime.getRuntime().freeMemory() - usage) + " bytes");
//    }

    private static void findEqualVoters(Document doc) throws Exception {
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();
        for (int i = 0; i < votersCount; i++) {
            Node node = voters.item(i);
            NamedNodeMap attributes = node.getAttributes();

            String name = attributes.getNamedItem("name").getNodeValue();
            String birthDay = attributes.getNamedItem("birthDay").getNodeValue();
//            Date birthDay = CommonMethod.birthDayFormat
//                    .parse(attributes.getNamedItem("birthDay").getNodeValue());

            DBConnection.countVoter(name, birthDay);
//
//            Voter voter = new Voter(name, birthDay);
//            Integer count = voterCounts.get(voter);
//            voterCounts.put(voter, count == null ? 1 : count + 1);
        }
        DBConnection.executeMultiInsert();
    }

    private static void fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = CommonMethod.visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }

    private static void print() {
        //Printing results
        CommonMethod.print(voteStationWorkTimes, voterCounts);

    }
}
