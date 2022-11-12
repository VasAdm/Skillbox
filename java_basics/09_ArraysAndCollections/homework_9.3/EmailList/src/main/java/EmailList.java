import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class EmailList {
    TreeSet<String> emailList = new TreeSet<>();
    String regex = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}";

    public void add(String email) {
        if (email.matches(regex)) {
            emailList.add(email.toLowerCase());
        } else System.out.println("Неверный формат email");
    }

    public ArrayList<String> getSortedEmails() {
        return new ArrayList<>(emailList);
    }
}
