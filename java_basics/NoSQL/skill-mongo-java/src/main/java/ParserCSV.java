import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class ParserCSV {
    public static List<String[]> parse(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            return reader.readAll();

        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }
}
