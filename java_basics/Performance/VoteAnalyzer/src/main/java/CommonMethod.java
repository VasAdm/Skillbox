import java.text.SimpleDateFormat;
import java.util.HashMap;

public class CommonMethod {
    public static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    public static final SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    static void print(HashMap<Integer, WorkTime> voteStationWorkTimes, HashMap<Voter, Integer> voterCounts) {
        System.out.println("Voting station work times: ");
        for (Integer votingStation : voteStationWorkTimes.keySet()) {
            WorkTime workTime = voteStationWorkTimes.get(votingStation);
            System.out.println("\t" + votingStation + " - " + workTime);
        }

        System.out.println("Duplicated voters: ");
        for (Voter voter : voterCounts.keySet()) {
            Integer count = voterCounts.get(voter);
            if (count > 1) {
                System.out.println("\t" + voter + " - " + count);
            }
        }
    }
}
