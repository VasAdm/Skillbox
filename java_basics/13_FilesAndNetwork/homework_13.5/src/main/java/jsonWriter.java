import core.Line;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class jsonWriter {

    private static final JSONObject lines = new JSONObject();

    public static void writer(ArrayList<Line> lineList, String path) {
        writerLines(lineList);
        writerStations(lineList);

        try (FileWriter file = new FileWriter(path)) {
            file.write(lines.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writerLines(ArrayList<Line> lineList) {
        JSONArray ln = new JSONArray();

        lineList.forEach(line -> {
            JSONObject data = new JSONObject();
            data.put("number", line.getNumber());
            data.put("name", line.getName());
            ln.add(data);
        });
        lines.put("lines", ln);
    }

    private static void writerStations(ArrayList<Line> lineList) {
        JSONObject stationsArray = new JSONObject();
        lineList.forEach(line -> stationsArray.put(line.getNumber(), line.getStations()));
        lines.put("stations", stationsArray);
    }
}
