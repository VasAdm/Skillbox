import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class jsonReader {

    public static void parseJson(String pathToFile) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile(pathToFile));

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");

            stationsObject.keySet().forEach(lineName -> {
                JSONArray stations = (JSONArray) stationsObject.get(lineName);
                System.out.println(lineName + " -> " + stations.size());
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getJsonFile(String pathToFile) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToFile));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return builder.toString();
    }
}