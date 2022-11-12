import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Loader {


    public static void main(String[] args) {

        int core = Runtime.getRuntime().availableProcessors();
        List<Integer> regCount = new ArrayList<>();

        for (int regionCode = 1; regionCode < 200; regionCode++) {
            regCount.add(regionCode);
        }



        int newListSize;
        while (regCount.size() > 0) {
            newListSize = Math.min(core, regCount.size());
            List<Integer> partOfFiles = new ArrayList<>(regCount.subList(0, newListSize));
            regCount.removeAll(partOfFiles);
            LoaderMultiThreading carNumGenerator = new LoaderMultiThreading(partOfFiles);
            new Thread(carNumGenerator).start();
        }
    }

}
