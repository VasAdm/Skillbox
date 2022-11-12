import java.io.File;

public class Loader {

    public static void main(String[] args) {
        File file = new File("res/data-1M.xml");
//XMLHandler Parsing
        XMLHandler xmlHandler = new XMLHandler(file);
        Thread thread = new Thread(xmlHandler);
        thread.start();
// DOM Parsing
//        DOMParser domParser = new DOMParser(file);
//        Thread thread1 = new Thread(domParser);
//        thread1.start();
    }
}