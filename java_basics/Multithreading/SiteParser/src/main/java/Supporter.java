import java.util.Set;
import java.util.TreeSet;

public class Supporter {
    private static final Set<String> links = new TreeSet<>();

    public static Set<String> getLinks() {
        return links;
    }

    public static void addLink(String str) {
        links.add(str);
    }
}