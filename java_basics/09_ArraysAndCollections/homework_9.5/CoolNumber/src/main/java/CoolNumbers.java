import nl.flotsam.xeger.Xeger;

import java.util.*;

public class CoolNumbers {
    private static final String letterList = "[АВЕКМНОРСТУХ]";
    private static final String regex = letterList + "{1}[0-9]{3}" + letterList + "{2}(0[1-9]|[1-9][0-9]|1[0-9][0-9])";
    private static final Xeger generator = new Xeger(regex);

    public static ArrayList<String> generateCoolNumbers() {
        ArrayList<String> autoNumbers = new ArrayList<>();
        for (int i = 0; i < 2_000_000; i++) {
            autoNumbers.add(generator.generate());
        }
        return autoNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return (Collections.binarySearch(sortedList, number) >= 0);

    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}
