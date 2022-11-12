import com.opencsv.*;

import java.io.FileReader;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Movements {
    private List<String[]> fileAsList = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        CSVParser csvParser = new CSVParserBuilder().withEscapeChar('\'').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(pathMovementsCsv))
                .withCSVParser(csvParser)   // custom CSV parser
                .withSkipLines(1)           // skip the first line, header info
                .build()) {
            fileAsList = reader.readAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public double getExpenseSum() {
        return fileAsList.stream()
                .map(x -> {
                    String num = x[7].replace(",", ".");
                    return Double.parseDouble(num);
                })
                .reduce(Double::sum)
                .get();
    }

    public double getIncomeSum() {
        return fileAsList.stream()
                .map(x -> {
                    String num = x[6].replace(",", ".");
                    return Double.parseDouble(num);
                })
                .reduce(Double::sum)
                .get();
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("###,###.00");
        HashMap<String, Double> hm = new HashMap<>();
        StringBuilder expenses = new StringBuilder();

        fileAsList.forEach(s -> {
            String key = s[5].split("\\s{3,}")[1].replace("/", "\\");
            int startLine = key.indexOf('\\');
            key = key.substring(startLine).replace("\\", " ").trim();
            Double value = Double.parseDouble(s[7].replace(",", "."));
            hm.merge(key, value, Double::sum);
        });

        for (String key : hm.keySet()) {
            if (hm.get(key) == 0) continue;
            String tmp = key + " - " + formatter.format(hm.get(key)) + " руб." + System.lineSeparator();
             expenses.append(tmp);
        }

        return  "Сумма расходов: " + formatter.format(this.getExpenseSum()) + " руб." + System.lineSeparator() +
                "Сумма доходов: " + formatter.format(this.getIncomeSum()) + " руб." + System.lineSeparator() +
                System.lineSeparator() + "Суммы расходов по организациям:" + System.lineSeparator() + expenses ;
    }
}
